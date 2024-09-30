/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v02;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * V02 - Subsystem for listing and searching files by content.
 *
 * @author ThinhNPCE170008
 */
public class CSVProcessor {

    private List<String[]> dataCSV = new ArrayList<>();
    private String filePath;

    /**
     * This method is used to import data from CSV file address.
     *
     * @param path Path to CSV file
     * @throws Exception Throw exception if CSV file not found from path
     */
    public void importCSV(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("CSV file not found.");
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        // Clear the existing data before importing
        dataCSV.clear();

        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(";");
            dataCSV.add(fields);
        }
        reader.close();

        // Save the file path for future use (to overwrite later)
        this.filePath = path;

        System.out.println("CSV file imported successfully from:\n" + path);
    }

    /**
     * Method used to reformat address from CSV file
     */
    public void formatAddress() {
        if (dataCSV.isEmpty()) {
            System.out.println("CSV list is empty, no data to format.");
        } else {
            for (String[] entry : dataCSV) {
                if (entry.length > 4) { // Ensure that there is an address field
                    String address = entry[4].trim();
                    if (!address.isEmpty()) {
                        address = address.replaceAll("\\s+", " "); // Change all spaces back to a single space
                        String[] parts = address.split("-"); // Separate the address components with the "-" sign.
                        StringBuilder formattedAddress = new StringBuilder();
                        for (String part : parts) {
                            String trimmedPart = part.trim(); // Convert address name components to non-whitespace form
                            trimmedPart = standardizeString(trimmedPart); // Standardize capitalization of the address part
                            formattedAddress.append(trimmedPart).append(" - "); // Concatenate the components separated by "-"
                        }
                        String result = formattedAddress.toString().trim();
                        if (result.endsWith(" -")) {
                            result = result.substring(0, result.length() - 2); // Remove the extra "-" at the end
                        }
                        entry[4] = result; // Update the address field
                    }
                }
            }
            System.out.println("Address formatting complete.");
        }
    }

    /**
     * Method used to reformat names from CSV file
     */
    public void formatName() {
        if (dataCSV.isEmpty()) {
            System.out.println("CSV list is empty, no data to format.");
        } else {
            for (String[] entry : dataCSV) {
                if (entry.length > 1) { // Ensure that there is a name field
                    String name = entry[1].trim();
                    entry[1] = standardizeString(name); // Update the name field
                }
            }
            System.out.println("Name formatting complete.");
        }
    }

    /**
     * Helper method to standardize string (capitalize first letter of each
     * word)
     *
     * @param input Specify name from formatName() method
     * @return Returns the well-formatted name
     */
    private String standardizeString(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        String[] words = input.toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1)).append(" ");
            }
        }
        return result.toString().trim();
    }

    /**
     * This method is used to export the CSV file to the original location with
     * a new name.
     *
     * @param path Path to the CSV file
     * @throws Exception Throws exception if unable to write data to file
     */
    public void exportCSV(String path) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));

        // Write the formatted data to the CSV file
        for (String[] entry : dataCSV) {
            writer.write(String.join(",", entry));
            writer.newLine();
        }
        writer.close();
        System.out.println("CSV file exported successfully. ");
    }
}
