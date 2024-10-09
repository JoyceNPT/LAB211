/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s11;

import java.util.Scanner;

/**
 * S11 - Reverse a string
 *
 * @author ThinhNPCE170008
 */
public class S11 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringReverser reverser = new StringReverser();

        while (true) {
            System.out.print("Please enter string: ");
            String inputString = sc.nextLine(); // Get the input string from the user and trim spaces

            // Check for special characters
            if (!inputString.matches("[a-zA-Z0-9 _]+")) {
                System.out.println("Error: Input string cannot contain special characters. Please re-enter.");
                continue;
            }

            // Check consecutive separator characters
            if (inputString.contains("  ") || inputString.contains("__") || inputString.contains("_ ") || inputString.contains(" _")) {
                System.out.println("Error: Input string cannot contain consecutive delimiter characters. Please re-enter.");
                continue;
            }

            // Check if the first and last characters are letters or numbers
            if (!Character.isLetterOrDigit(inputString.charAt(0)) || !Character.isLetterOrDigit(inputString.charAt(inputString.length() - 1))) {
                System.out.println("Error: The first and last characters of the input string must be letters or numbers.\nPlease re-enter.");
                continue;
            }

            // Display original and reversed strings
            String reversedString = reverser.reverseString(inputString);
            System.out.println("The old string: " + inputString);
            System.out.println("The reversed string: " + reversedString);

            // Ask if the user wants to continue or exit
            System.out.println("Press Enter to continue another reverse, or type 'ESC' to exit.");
            String userInput = sc.nextLine().trim();

            // Exit if the user types 'ESC'
            if (userInput.equalsIgnoreCase("ESC")) {
                System.out.println("Exiting program...");
                return;
            }
        }
    }
}
