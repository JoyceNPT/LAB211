/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v07;

import java.util.Scanner;

/**
 * V07 - Lucky Number Game
 *
 * @author ThinhNPCE170008
 */
public class V07 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialize variables to store game stats
        MyGame game = new MyGame();
        Scanner sc = new Scanner(System.in);  // Single Scanner instance

        boolean playAgain;

        do {
            // Game logic starts here
            System.out.println("Welcome to the lucky number guessing game!");
            System.out.println("Try to guess the lucky number between 0 and " + game.MAX_NUMBER);

            int luckyNumber = game.generateLuckyNumber();  // Generate random number
            int guess;

            // Game loop where user keeps guessing until correct
            do {
                // Use inline validation for input inside main
                while (true) {
                    System.out.print("Enter your guess: ");
                    try {
                        guess = Integer.parseInt(sc.nextLine());  // Read user input

                        // Check if the guess is within the valid range
                        if (guess < 0 || guess > game.MAX_NUMBER) {
                            System.out.println("Error: The number must be between 0 and " + game.MAX_NUMBER + ". Please try again.");
                        } else {
                            break;  // Valid input, break out of the loop
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Please enter a valid integer.");
                    }
                }

                // Compare guess with lucky number and provide feedback
                game.compareNumbers(guess, luckyNumber);
            } while (guess != luckyNumber);  // Keep looping until the user guesses correctly

            // Ask if the user wants to play again
            System.out.print("Do you want to continue playing? (y/yes or any other key to stop): ");
            String response = sc.nextLine().trim().toLowerCase();
            playAgain = response.equals("y") || response.equals("yes");

        } while (playAgain);  // Loop for a new game if the player wants to continue

        // Call the report function to display the final game results
        game.report();
    }
}
