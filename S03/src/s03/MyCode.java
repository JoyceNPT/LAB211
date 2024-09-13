package s03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * S03 - English dictionary
 *
 * @author ThinhNPCE170008
 */
public class MyCode {

    private static final String DATA_DIR = "library/";

    /**
     * The constructor is used to check if the directory containing the data
     * exists.
     */
    public MyCode() {
        File dir = new File(DATA_DIR);
        if (!dir.exists()) {
            dir.mkdirs(); // Create directory if it doesn't exist
        }
    }

    /**
     * Main menu of the program
     */
    public void printMenu() {
        System.out.println("1. Create a new word");
        System.out.println("2. Edit a word");
        System.out.println("3. Look up meaning");
        System.out.println("4. Exit");
        System.out.print("Please choose a number (1-4): ");
    }

    /**
     * Method used to write words and meanings to file
     *
     * @param word New words are waiting to be checked and written to file.
     * @param meaning The corresponding meaning of the word is being checked and
     * written to the file.
     */
    public void addWord(String word, String meaning) {
        // Create 2 data stores word and meaning in the library directory
        char firstChar = Character.toLowerCase(word.charAt(0));
        String indexFile = DATA_DIR + firstChar + "_index.dat";
        String meaningFile = DATA_DIR + firstChar + "_meaning.dat";

        try {
            // Create the files if they do not exist
            File indexFileObj = new File(indexFile);
            File meaningFileObj = new File(meaningFile);

            if (!indexFileObj.exists()) {
                indexFileObj.createNewFile();
            }
            if (!meaningFileObj.exists()) {
                meaningFileObj.createNewFile();
            }

            // Load words and normalize case for comparison
            HashMap<String, String> words = loadWords(indexFile, meaningFile);
            String normalizedWord = word.toLowerCase();  // Normalize to lowercase for most accurate comparison

            // Check if the normalized word already exists
            if (words.containsKey(normalizedWord)) {
                System.out.println("This word already exists, please enter a new word.");
                return;
            }

            // Write new words and their meanings into the file (in lowercase)
            try (BufferedWriter indexWriter = new BufferedWriter(new FileWriter(indexFile, true));
                    BufferedWriter meaningWriter = new BufferedWriter(new FileWriter(meaningFile, true))) {
                indexWriter.write(normalizedWord + "\n");
                meaningWriter.write(meaning + "\n");
                System.out.println("Word added successfully.");
            }
        } catch (IOException e) {
            System.out.println("Error adding word: " + e.getMessage());
        }
    }

    /**
     * Method to update the meaning for the specified word
     *
     * @param word The word is specified to update the meaning
     * @param meaning New meaning of the specified word
     */
    public void updateWord(String word, String meaning) {
        // Create two String addresses to point to the correct file containing the specified word and meaning
        char firstChar = Character.toLowerCase(word.charAt(0));
        String indexFile = DATA_DIR + firstChar + "_index.dat";
        String meaningFile = DATA_DIR + firstChar + "_meaning.dat";

        try {
            // Load words and normalize case for comparison
            HashMap<String, String> words = loadWords(indexFile, meaningFile);
            String normalizedWord = word.toLowerCase();  // Normalize to lowercase for comparison

            // Checks if the specified word exists, if so updates its meaning
            if (words.containsKey(normalizedWord)) {
                words.put(normalizedWord, meaning);
                saveWords(indexFile, meaningFile, words);
                System.out.println("Word updated successfully.");
            } else {
                System.out.println("Word not found.");
            }
        } catch (IOException e) {
            System.out.println("Error updating word: " + e.getMessage());
        }
    }

    /**
     * How to search for words and their meanings in a data library
     *
     * @param word The specified word to search in the data library
     * @return Return null or handle the error properly
     */
    public String lookupWord(String word) {
        String normalizedInput = word.toLowerCase();  // Normalize the entire input for comparison
        HashMap<String, String> allWords = new HashMap<>();

        // Load all words from all files in the library
        for (char c = 'a'; c <= 'z'; c++) {
            String indexFile = DATA_DIR + c + "_index.dat";
            String meaningFile = DATA_DIR + c + "_meaning.dat";
            try {
                HashMap<String, String> words = loadWords(indexFile, meaningFile);
                allWords.putAll(words);
            } catch (IOException e) {
                System.out.println("Error loading words from file: " + e.getMessage());
            }
        }

        // Look up the exact word
        if (allWords.containsKey(normalizedInput)) {
            return allWords.get(normalizedInput);  // Return the meaning of the word if found
        } else {
            // Word not found, print message and suggest similar words
            System.out.println("Word not found. Here are similar words:");
            boolean foundSimilarWords = false;

            // Find words that contain the input as a substring or have substrings that match the input
            for (String key : allWords.keySet()) {
                if (key.contains(normalizedInput)) {
                    System.out.println("- " + key);
                    foundSimilarWords = true;
                }
            }

            if (!foundSimilarWords) {
                System.out.println("No similar words found.");
            }
            return null;  // Return null if the exact word wasn't found
        }
    }

    /**
     * HashMap is used to load the words and meanings of files in the library
     * data
     *
     * @param indexFile Points to the file containing the word in the data
     * library
     * @param meaningFile Points to the file containing the meaning in the data
     * library
     * @return Returns words and their corresponding meanings from the specified
     * files
     * @throws IOException Catch exception if link to file is broken
     */
    private HashMap<String, String> loadWords(String indexFile, String meaningFile) throws IOException {
        HashMap<String, String> words = new HashMap<>();
        File indexFileObj = new File(indexFile);
        File meaningFileObj = new File(meaningFile);

        // Create files if they don't exist
        if (!indexFileObj.exists()) {
            indexFileObj.createNewFile();
        }
        if (!meaningFileObj.exists()) {
            meaningFileObj.createNewFile();
        }

        // Read words and meanings, store them in HashMap for easy lookup.
        try (BufferedReader indexReader = new BufferedReader(new FileReader(indexFile));
                BufferedReader meaningReader = new BufferedReader(new FileReader(meaningFile))) {
            String word;
            String meaning;
            while ((word = indexReader.readLine()) != null && (meaning = meaningReader.readLine()) != null) {
                words.put(word, meaning);
            }
        }
        return words;
    }

    /**
     * Save updated words to file
     *
     * @param indexFile Points to the file containing the word in the data
     * library
     * @param meaningFile Points to the file containing the meaning in the data
     * library
     * @param words Points to the file containing the meaning in the data
     * library
     * @throws IOException Catch exception if link to file is broken
     */
    private void saveWords(String indexFile, String meaningFile, HashMap<String, String> words) throws IOException {
        try (BufferedWriter indexWriter = new BufferedWriter(new FileWriter(indexFile));
                BufferedWriter meaningWriter = new BufferedWriter(new FileWriter(meaningFile))) {

            for (String word : words.keySet()) {
                indexWriter.write(word + "\n"); // Save each word to the index file
                meaningWriter.write(words.get(word) + "\n"); // Save each meaning to the meaning file
            }
        }
    }
}
