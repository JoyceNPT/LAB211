/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s12;

import java.util.Scanner;

/**
 * S12 - Convert binary, octal and hexadecimal to decimal
 *
 * @author ThinhNPCE170008
 */
public class S12 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyConvert mc = new MyConvert();
        int choice;

        while (true) {
            System.out.println("1. Convert binary number to decimal number");
            System.out.println("2. Convert octal number to decimal number");
            System.out.println("3. Convert hexadecimal number to decimal number");
            System.out.println("4. Exit");

            choice = MyLib.getChoiceConditional("Please choose number (1 – 4): ", "Invalid choice, please re-enter", 1, 4);

            switch (choice) {
                case 1:
                    // Binary to Decimal
                    while (true) {
                        System.out.print("Enter binary number: ");
                        String binary = sc.nextLine().trim(); // Trim to remove leading and trailing whitespaces
                        if (binary.isEmpty() || !binary.matches("[01]+")) {
                            System.out.println("Invalid binary number. Binary numbers must only contain 0 and 1 and cannot be empty.");
                            System.out.println("Please re-enter.");
                        } else {
                            long decFromBi = mc.biToDec(binary);
                            System.out.println("Decimal number is: " + decFromBi);
                            break; // Exit the loop if input is valid
                        }
                    }
                    break;

                case 2:
                    // Octal to Decimal
                    while (true) {
                        System.out.print("Enter octal number: ");
                        String octal = sc.nextLine().trim(); // Trim to remove leading and trailing whitespaces
                        if (octal.isEmpty() || !octal.matches("[0-7]+")) {
                            System.out.println("Invalid octal number. Octal numbers must only contain digits 0 to 7 and cannot be empty.");
                            System.out.println("Please re-enter.");
                        } else {
                            long decFromOct = mc.octToDec(octal);
                            System.out.println("Decimal number is: " + decFromOct);
                            break; // Exit the loop if input is valid
                        }
                    }
                    break;

                case 3:
                    // Hexadecimal to Decimal
                    while (true) {
                        System.out.print("Enter hexadecimal number: ");
                        String hex = sc.nextLine().trim().toUpperCase(); // Trim to remove leading and trailing whitespaces
                        if (hex.isEmpty() || !hex.matches("[0-9A-F]+")) {
                            System.out.println("Invalid hexadecimal number. Hexadecimal numbers must only contain digits 0-9 and letters A-F (10-15) and cannot be empty.");
                            System.out.println("Please re-enter.");
                        } else {
                            long decFromHex = mc.hexToDec(hex);
                            System.out.println("Decimal number is: " + decFromHex);
                            break; // Exit the loop if input is valid
                        }
                    }
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice, please choose again.");
            }

            System.out.println();
        }
    }

}
