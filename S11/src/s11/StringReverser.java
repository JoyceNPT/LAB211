/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s11;

/**
 * S11 - Reverse a string
 *
 * @author ThinhNPCE170008
 */
public class StringReverser {

    /**
     * Method to reverse a string while preserving case and underscore/space
     * positions
     *
     * @param input Pass string from input
     * @return Returns the reversed string
     */
    public String reverseString(String input) {
        // Split the input string by spaces and underscores
        String[] words = input.split("((?=_)|(?<=_))|((?<=\\s)|(?=\\s))");  // Split by underscore or space, and keep the separators
        // Reverse the wordsAndSeparators array
        StringBuilder reversedString = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i]);
        }
        return reversedString.toString();
    }
}
