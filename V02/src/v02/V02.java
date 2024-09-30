/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v02;

import java.util.Scanner;

/**
 * V02 - Subsystem for listing and searching files by content.
 *
 * @author ThinhNPCE170008
 */
public class V02 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CSVProcessor processor = new CSVProcessor();
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Display menu
            System.out.println("Select an option:");
            System.out.println("1. Import CSV");
            System.out.println("2. Format Address");
            System.out.println("3. Format Name");
            System.out.println("4. Export CSV");
            System.out.println("5. Exit");

            int choice = MyLib.getChoiceConditional("Please choice one option: ", "Invalid choice, please re-enter.", 1, 5);

            try {
                switch (choice) {
                    case 1: // Function 1: Import CSV file.
                        System.out.print("Enter path of CSV file: ");
                        String path = sc.nextLine();
                        processor.importCSV(path);
                        break;
                    case 2: // Function 2: Format Address
                        processor.formatAddress();
                        break;
                    case 3: // Function 3: Format Name
                        processor.formatName();
                        break;
                    case 4: // Function 4: Export CSV file.
                        System.out.print("Enter file name to export: ");
                        String exportPath = sc.nextLine();
                        processor.exportCSV(exportPath);
                        break;
                    case 5: // Function 5: Exit Program
                        System.out.println("Exiting program.");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}
