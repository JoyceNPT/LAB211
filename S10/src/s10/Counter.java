/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s10;

import java.util.HashMap;
import java.util.Map;

/**
 * S10 - Count the number of the appearance of letters in a string.
 *
 * @author ThinhNPCE170008
 */
public class Counter {

    // A map to store the letter counts
    private Map<Character, Integer> charCounts = new HashMap<>();

    /**
     * Method used to count the number of occurrences of characters in a string
     *
     * @param input Pass in string from input
     */
    public void countCharacters(String input) {
        // Iterate over each character in the input string
        for (char c : input.toCharArray()) {
            // Skip whitespace characters
            if (Character.isWhitespace(c)) {
                continue; // Skip to the next iteration
            }

            // Check if the character is a letter
            if (Character.isLetter(c)) {
                // Convert to lowercase and count it as a letter
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            } // Check if the character is a digit
            else if (Character.isDigit(c)) {
                // Count it as a digit
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            } // If it's neither a letter nor a digit, count it as a special character
            else {
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            }
        }
    }

    /**
     * Print the characters and their occurrences
     */
    public void displayLetter() {
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
