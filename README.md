# High Low - A Simple Console Game Made with Java
___

## Premise
- Guess a number between 1 and 100
- Get feedback if the guess is too high, too low, or correct
- Keep guessing until the correct number is found
- Example:
   - User guesses `76`
   - Computer compares that to the value of `37`
   - Computer says `Too high!`, as 76 is greater than 37
   - User guesses again, a value of `25`
   - Computer says `Too low!`, as 25 is less than 37
   - User guesses again, a value of `37`
   - Computer says a message like `Correct! You've guessed the number!`

## Pseudocode
1. Get a random number between 0 and 100
2. Ask the user to guess a number
3. Compare the guess to the random number and give feedback
   - If the guess is too high, then give the user a message, like `Too high!`
   - If the guess is too low, then give the user a message, like `Too low!`
     - guess - number: **CONDITIONAL WE'RE TESTING**
       - If guess is greater, then the answer will be positive
         - The greater the guess, the more positive the answer will be
       - if guess is less, then the answer will be negative
         - The lesser the guess, the more negative the answer will be
       - Code Example:
       ``` java
              if (userGuess - randomNum > 10) {           // More than 10 away
                  System.out.println("Too high!");
              } else if (userGuess - randomNum > 0) {     // Under 10 away
                  System.out.println("High, but close!");}
              }
       ```

4. Repeat until the guess is correct
   -  If the guess is correct, then, again, give the user a message, like `Correct! You've guessed the number!`
