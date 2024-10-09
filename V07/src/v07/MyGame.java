/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * V07 - Lucky Number Game
 *
 * @author ThinhNPCE170008
 */
public class MyGame {

    public static final int MAX_NUMBER = 100;  // Define the maximum value for the lucky number
    private int totalGames = 0;
    private int totalGuesses = 0;
    private int guessCount = 0; // Keep track of the number of guesses
    private int bestGame = Integer.MAX_VALUE;  // Track the best game (minimum guesses)
    private List<Integer> bestGames = new ArrayList<>();

    /**
     * Method to generate a random lucky number
     *
     * @return Returns a random number from 0 to MAX_NUMBER
     */
    public int generateLuckyNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER + 1);  // Generate random number between 0 and MAX_NUMBER
    }

    /**
     * Method to compare the guessed number and lucky number and print feedback
     *
     * @param guess Pass in lucky number from user
     * @param luckyNumber Enter lucky number from program
     */
    public void compareNumbers(int guess, int luckyNumber) {
        guessCount++; // Increment guess count for each attempt

        if (guess > luckyNumber) {
            System.out.println("The lucky number is smaller than your predicted number.");
        } else if (guess < luckyNumber) {
            System.out.println("The lucky number is greater than your predicted number.");
        } else {
            System.out.println("Congratulations, you guessed the lucky number correctly!");

            // Update game statistics
            totalGames++;
            totalGuesses += guessCount; // Add guessCount to totalGuesses

            // Check if the current game is the best game
            if (guessCount < bestGame) {
                bestGame = guessCount;
                bestGames.clear();
                bestGames.add(totalGames); // Store the game number with the best performance
            } else if (guessCount == bestGame) {
                bestGames.add(totalGames);
            }

            guessCount = 0; // Reset guessCount to 0 after each game
        }
    }

    /**
     * Returns information when the game ends
     */
    public void report() {
        double avgGuessesPerGame = (double) this.totalGuesses / this.totalGames;

        System.out.println("\nGame Report:");
        System.out.println("Total games played: " + this.totalGames);
        System.out.println("Total guesses: " + this.totalGuesses);
        System.out.println("Average guesses per game: " + avgGuessesPerGame + "\n");
        System.out.println("Best game(s) (fewest guesses): " + this.bestGame + " guesses.");

        if (this.bestGames.size() > 1) {
            System.out.print("Best games: ");
            for (int i : this.bestGames) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            System.out.println("Best game: " + this.bestGames.get(0));
        }
    }
}
