/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s05;

import java.util.Scanner;

/**
 * S05 - Analyze the user input string.
 *
 * @author ThinhNPCE170008
 */
public class S05 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Display the GUI and input data
        System.out.println("===== Analysis String Program =====");

        Scanner sc = new Scanner(System.in);
        String input;
        boolean flag;
        // Use do while loop to check input string
        do {
            flag = false;
            System.out.print("Input String: ");
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Invalid input, Please re-enter.");
                flag = true;
            }
        } while (flag);

        // Create an object of Analysis class
        Analysis ana = new Analysis();
        ana.getNumberAnalysis(input);
        ana.getCharacterAnalysis(input);

        // Print the input parse string
        System.out.println("\n----- Result Analysis -----");
        System.out.println(ana.toString());
    }
}
