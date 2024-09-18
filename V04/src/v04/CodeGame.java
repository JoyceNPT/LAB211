package v04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * V04 - Simple Slot Machine.
 *
 * @author ThinhNPCE170008
 */
public class CodeGame {

    private static final String FILE_NAME = "money_data.txt";
    private double money;
    private Random random;

    /**
     * Initializes a new game instance by loading saved money or starting with
     * $10.
     */
    public CodeGame() {
        this.money = loadMoney();
        this.random = new Random();
    }

    /**
     * Returns a new instance of the CodeGame class.
     *
     * @return a new instance of the CodeGame class.
     */
    public static CodeGame getNewGame() {
        return new CodeGame();
    }

    /**
     * Checks if player has enough money, generates random digits, and
     * determines winnings.
     */
    public void playGame() {
        if (money >= 0.25) {
            // Each time you play, deduct the player's money by $0.25.
            money -= 0.25;
            int digit1 = random.nextInt(10);
            int digit2 = random.nextInt(10);
            int digit3 = random.nextInt(10);

            System.out.printf("The slot machine shows %d%d%d.%n", digit1, digit2, digit3);

            // Determine winnings
            if (digit1 == digit2 && digit2 == digit3) {
                System.out.println("You win the big prize, $10.00!"); // If all 3 random numbers are the same, the player wins $10.
                money += 10.00;
            } else if (digit1 == digit2 || digit1 == digit3 || digit2 == digit3) {
                System.out.println("You win 50 cents!"); // If no random numbers match, the player loses $0.5
                money += 0.50;
            } else {
                System.out.println("Sorry, you don't win anything.");
            }
        } else {
            System.out.println("You don't have enough money to play.");
        }
    }

    /**
     * Saves the current game state to a file.
     */
    public void saveGame() {
        saveMoney(money);
    }

    /**
     * Ends the game, prints a farewell message, and clears the saved data.
     */
    public void cashOut() {
        System.out.printf("Thank you for playing! You end with $%.2f.%n", money);
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            // Clear the file by writing nothing to it
        } catch (IOException e) {
            System.out.println("Error clearing file: " + e.getMessage());
        }
    }

    /**
     * Returns the player's current balance.
     *
     * @return the player's current balance.
     */
    public double getMoney() {
        return money;
    }

    /**
     * Saves the given amount of money to the file.
     *
     * @param money Save the amount of money the player has won to a file
     */
    public static void saveMoney(double money) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            writer.println(money);
        } catch (IOException e) {
            System.out.println("Error saving money: " + e.getMessage());
        }
    }

    /**
     * Loads the saved money from the file, or returns $10.00 if no file is
     * found.
     *
     * @return Returns existing amount or issues new amount
     */
    public static double loadMoney() {
        double money = 10.00; // Default starting money if no save file is found
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            if (line != null) {
                money = Double.parseDouble(line);
            }
        } catch (IOException e) {
            System.out.println("No previous save found, starting with $10.00.");
        }
        return money;
    }
}
