/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s03;

import java.util.Scanner;

/**
 * S03 - English dictionary
 *
 * @author ThinhNPCE170008
 */
public class S03 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyCode code = new MyCode();
        Scanner sc = new Scanner(System.in);

        // Use While loop with infinite running condition, only stop when user specified
        while (true) {
            code.printMenu();
            // Check input via method in library
            int choice = MyLib.getChoiceConditional("", "Invalid choice. Please try again.", 1, 4);

            // Use switches so that the user can select the desired function.
            switch (choice) {
                case 1: // Create new words and meanings
                    System.out.print("Enter a new word: ");
                    String newWord = MyLib.getNameUser("", "Invalid word. Please try again.");
                    System.out.print("Meaning: ");
                    String meaning = MyLib.getPara("", "Invalid mean. Please try again.");
                    code.addWord(newWord, meaning);
                    break;
                case 2: // Update existing words and meanings
                    System.out.print("Enter a word to update: ");
                    String wordToUpdate = MyLib.getNameUser("", "Invalid word. Please try again.");
                    System.out.print("Meaning: ");
                    String updatedMeaning = MyLib.getPara("", "Invalid mean. Please try again.");
                    code.updateWord(wordToUpdate, updatedMeaning);
                    break;
                case 3: // Look up existing words and meanings
                    System.out.print("Enter a word to look up: ");
                    String wordToLookup = MyLib.getNameUser("", "Invalid word. Please try again.");
                    meaning = code.lookupWord(wordToLookup);
                    if (meaning != null) {
                        System.out.println("Meaning: " + meaning);
                    }
                    break;
                case 4: //Stop the program, use return to break the loop
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
