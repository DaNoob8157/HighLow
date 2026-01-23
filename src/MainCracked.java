/*
 MainCracked.java
Created by DaNob8157 on 1/20/26
*/

// Import modules needed
import java.util.Scanner;  // Remove this if not using console fallback
import javax.swing.*;      // Add for Swing components
import java.awt.*;          // Add for layouts and events
import java.awt.event.*;    // Add for event handling

// Name class
public class MainCracked extends JFrame implements ActionListener {  // Extend JFrame and implement ActionListener for event handling
    private int randomNum;
    private JTextField guessField;
    private JButton guessButton;
    private JButton playAgainButton;
    private JLabel feedbackLabel;
    private JLabel instructionLabel;

    public MainCracked() {
        // Set up the GUI window
        setTitle("High-Low Guessing Game");
        setSize(400, 300);
        setResizable(false);  // Make window non-resizable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create main panel with vertical layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(30, 30, 30));

        // Input panel for text field and label
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.setBackground(new Color(30, 30, 30));
        instructionLabel = new JLabel("Guess a number between 0 and 100:");
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructionLabel.setForeground(new Color(200, 200, 200));
        guessField = new JTextField(15);
        guessField.setMaximumSize(guessField.getPreferredSize());
        guessField.setAlignmentX(Component.CENTER_ALIGNMENT);
        guessField.setBackground(new Color(50, 50, 50));
        guessField.setForeground(new Color(200, 200, 200));
        guessField.setCaretColor(new Color(200, 200, 200));
        inputPanel.add(instructionLabel);
        inputPanel.add(Box.createVerticalStrut(5));
        inputPanel.add(guessField);

        // Button panel for guess button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setBackground(new Color(30, 30, 30));
        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);
        guessButton.setBackground(new Color(60, 60, 60));
        guessButton.setForeground(new Color(200, 200, 200));
        guessButton.setFocusPainted(false);
        guessButton.setBorderPainted(false);
        guessButton.setOpaque(true);
        buttonPanel.add(guessButton);

        // Feedback label
        feedbackLabel = new JLabel("");
        feedbackLabel.setHorizontalAlignment(SwingConstants.CENTER);
        feedbackLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        feedbackLabel.setFont(new Font("Arial", Font.BOLD, 14));
        feedbackLabel.setForeground(new Color(100, 200, 100));

        // Play again button
        JPanel playAgainPanel = new JPanel();
        playAgainPanel.setLayout(new BoxLayout(playAgainPanel, BoxLayout.X_AXIS));
        playAgainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        playAgainPanel.setBackground(new Color(30, 30, 30));
        playAgainButton = new JButton("Play Again");
        playAgainButton.addActionListener(this);
        playAgainButton.setVisible(false);
        playAgainButton.setBackground(new Color(60, 60, 60));
        playAgainButton.setForeground(new Color(200, 200, 200));
        playAgainButton.setFocusPainted(false);
        playAgainPanel.add(playAgainButton);

        // Add components to main panel
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(feedbackLabel);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(playAgainPanel);
        mainPanel.add(Box.createVerticalGlue());

        add(mainPanel);

        // Start the game
        startNewGame();
    }

    private void startNewGame() {
        // 1. Create a random number between 0 and 100
        randomNum = (int) (Math.random() * 101);
        feedbackLabel.setText("");
        guessField.setText("");
        guessButton.setEnabled(true);
        playAgainButton.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            // Parse user input
            try {
                int userGuess = Integer.parseInt(guessField.getText());
                // 3. Compare the guess to the random number and give feedback
                int difference = userGuess - randomNum;
                if (difference > 25) {
                    feedbackLabel.setText("Too high!");
                } else if (difference > 10) {
                    feedbackLabel.setText("High, but close!");
                } else if (difference > 0) {
                    feedbackLabel.setText("High, but extremely close!");
                } else if (difference < -25) {
                    feedbackLabel.setText("Too low!");
                } else if (difference < -10) {
                    feedbackLabel.setText("Low, but close!");
                } else if (difference < 0) {
                    feedbackLabel.setText("Low, but extremely close!");
                } else {
                    feedbackLabel.setText("You got it! The number was: " + randomNum);
                    guessButton.setEnabled(false);
                    playAgainButton.setVisible(true);
                    return;
                }
            } catch (NumberFormatException ex) {
                feedbackLabel.setText("Please enter a valid integer.");
            }
        } else if (e.getSource() == playAgainButton) {
            startNewGame();
        }
    }

    public static void main(String[] args) {
        // Enable system dark mode support BEFORE creating UI
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Run the GUI on the EDT
        SwingUtilities.invokeLater(() -> {
            new MainCracked().setVisible(true);
        });
    }
}
