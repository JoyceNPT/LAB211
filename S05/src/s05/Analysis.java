package s05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * S05 - Analyze the user input string.
 *
 * @author ThinhNPCE170008
 */
public class Analysis {

    private final HashMap<String, List<Integer>> numberResult;
    private final HashMap<String, StringBuilder> charResult;

    /**
     * The constructor is used to initialize two HashMaps of numbers and
     * characters.
     */
    public Analysis() {
        this.numberResult = new HashMap<>();
        this.charResult = new HashMap<>();
    }

    /**
     * Method used to parse input string and search for numbers in the string
     *
     * @param input User input string
     */
    public void getNumberAnalysis(String input) {
        // Initialize a list to store different types of numbers
        List<Integer> allNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> squareNumbers = new ArrayList<>();

        // Regular expression to find numbers in the string
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        // Use Matcher to iterate through a string and search for results that match an expression condition.
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            allNumbers.add(number);

            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }

            // Check for square numbers
            if (Math.sqrt(number) == Math.floor(Math.sqrt(number))) {
                squareNumbers.add(number);
            }
        }

        // Storing results in the HashMap
        numberResult.put("Square Numbers", squareNumbers);
        numberResult.put("Odd Numbers", oddNumbers);
        numberResult.put("Even Numbers", evenNumbers);
        numberResult.put("All Numbers", allNumbers);
    }

    /**
     * Method used to parse a string and search for characters in the string
     *
     * @param input User input string
     */
    public void getCharacterAnalysis(String input) {
        // Initialize a list to store different types of characters
        StringBuilder specialCharacters = new StringBuilder();
        StringBuilder uppercase = new StringBuilder();
        StringBuilder lowercase = new StringBuilder();

        // Regular expression to find special characters
        Pattern specialPattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher specialMatcher = specialPattern.matcher(input);

        // Convert the input string to a character array using toCharArray()
        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                uppercase.append(ch);
            } else if (Character.isLowerCase(ch)) {
                lowercase.append(ch);
            }
        }

        // Finding special characters
        while (specialMatcher.find()) {
            specialCharacters.append(specialMatcher.group());
        }

        // Storing results in the HashMap
        charResult.put("Uppercase Characters", uppercase);
        charResult.put("Lowercase Characters", lowercase);
        charResult.put("Special Characters", specialCharacters);

        // Create a StringBuilder to store all characters except numbers
        StringBuilder nonNumberCharacters = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                nonNumberCharacters.append(ch);
            }
        }
        charResult.put("All Characters", nonNumberCharacters);
    }

    /**
     * Returns the parsed values ​​from the input string
     *
     * @return the string format of array
     */
    @Override
    public String toString() {
        // Use StringBuilder to concatenate the returned results into a string in the required format
        StringBuilder result = new StringBuilder();

        result.append("Square Numbers: ").append(numberResult.get("Square Numbers")).append("\n");
        result.append("Odd Numbers: ").append(numberResult.get("Odd Numbers")).append("\n");
        result.append("Even Numbers: ").append(numberResult.get("Even Numbers")).append("\n");
        result.append("All Numbers: ").append(numberResult.get("All Numbers")).append("\n");

        result.append("Uppercase Characters: ").append(charResult.get("Uppercase Characters")).append("\n");
        result.append("Lowercase Characters: ").append(charResult.get("Lowercase Characters")).append("\n");
        result.append("Special Characters: ").append(charResult.get("Special Characters")).append("\n");
        result.append("All Characters: ").append(charResult.get("All Characters")).append("\n");

        return result.toString();
    }
}
