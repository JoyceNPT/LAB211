/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s10;

import java.util.Scanner;

/**
 * S10 - Count the number of the appearance of letters in a string.
 *
 * @author ThinhNPCE170008
 */
public class S10 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Counter count = new Counter();
        String inputData = "";

        // Loop until a valid input is received
        while (true) {
            // Prompt the user for input
            System.out.print("Enter a string: ");
            inputData = sc.nextLine();

            // Check if the input is empty or contains only whitespace
            if (inputData.trim().isEmpty() || inputData.contains("  ")) {
                System.out.println("Error: Input cannot be empty or whitespace only. Please try again.");
            } else {
                break; // Valid input received, exit the loop
            }
        }

        // Call the count method
        count.countCharacters(inputData);

        // Call the method to print the number of occurrences
        count.displayLetter();
    }

}
