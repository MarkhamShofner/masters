/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3_2;
import java.util.Scanner;

/**
 *
 * @author mark8604
 */
public class Assignment3_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        boolean optingToPlay = true;
        // Game loop that runs at least once
        do {
            // Grab initial inputs from the user
            System.out.println("Let's play a game where you try to guess a random number!");
            System.out.println("First, pick a positive number that is greater than 1 (this will be the ceiling of the guessing range):");
            int rangeTop = input.nextInt();
            System.out.println("Second, what is the maximum number of guesses you would like to allow yourself?");
            int maxGuesses = input.nextInt();

            int guesses = maxGuesses;
            boolean success = false;
            // Generate the random number the user is trying to guess
            int randomNumber = (int) ( rangeTop * Math.random() ) + 1;

            while (guesses > 0) {
                // Grab the guess from the user
                System.out.println("Guess away!");
                int guess = input.nextInt();
                // Return information based on that guess
                if (guess == randomNumber) {
                    System.out.println("CORRECT! The answer was " + randomNumber + "!");
                    guesses = 0;
                    success = true;
                } else if (guess < randomNumber) {
                    System.out.println("TOO LOW! " + guess + " is below the answer!");
                } else if (guess > randomNumber) {
                    System.out.println("TOO HIGH! " + guess + " is above the answer!");
                }
                guesses--;
                if (!success) {
                    System.out.println("You have " + guesses + " guesses left!");
                }
            }
            if (!success) {
                System.out.println("You ran out of guesses D:");
            }

            // Check if the user wants to play again
            System.out.println("Would you like to play again? Input '1' for yes, '2' for no.");
            int playChoice = input.nextInt();

            if (playChoice == 1) {
                optingToPlay = true;
            } else if (playChoice == 2) {
                optingToPlay = false;
            } else {
                optingToPlay = true;
                System.out.println("Input not recognized, so we'll assume you want to play again!");
            }
        } while (optingToPlay);
    }

}
