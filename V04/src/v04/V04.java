/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v04;

import java.util.Scanner;

/**
 * V04 - Simple Slot Machine.
 *
 * @author ThinhNPCE170008
 */
public class V04 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new CodeGame object
        CodeGame game = CodeGame.getNewGame();

        // Main game loop
        while (game.getMoney() >= 0.25) {
            System.out.printf("You have $%.2f.%n", game.getMoney());
            System.out.println("Choose one of the following menu options:");
            System.out.println("1) Play the slot machine.");
            System.out.println("2) Save game.");
            System.out.println("3) Cash out.");

            int choice = MyLib.getChoiceConditional("", "Invalid selection, please re-enter selection (1-3).", 1, 3);

            switch (choice) {
                case 1: // Play the slot machine
                    game.playGame();
                    break;

                case 2: // Save the game
                    game.saveGame();
                    break;

                case 3: // Cash out
                    game.cashOut();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

            // Check if the player has run out of money
            if (game.getMoney() <= 0) {
                System.out.println("You have no money left. Goodbye!");
                return;
            }
        }
    }
}
