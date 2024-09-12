/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s02;

/**
 * S02 - String Array Manipulations.
 *
 * @author ThinhNPCE170008
 */
public class MyCal {

    private String[] names; // Array to store names

    /**
     * Method used to check the number of names and valid names
     *
     */
    public void inputData(int n) {
        // Once we have n, we let the created array have a maximum of n elements.
        names = new String[n];

        System.out.println("Enter " + n + " names");
        // We use a for loop to iterate through the elements from the user check and put them into the array.
        for (int i = 0; i < n; i++) {
            // We call and use the get Positive Integer method in the personal library to check the input (name)
            names[i] = MyLib.getNameUser("", "Your name is not in the correct format, please re-enter.");
        }
    }

    /**
     * Sort the names entered by the user in bubble sort algorithm
     */
    public void bubbleSort() {
        int n = names.length;
        // The fori loop is used to iterate through the array from 0 to (n - 1)
        for (int i = 0; i < n - 1; i++) {
            // The forj loop is used to compare and swap between two elements from 0 to (n - i - 1)
            for (int j = 0; j < n - i - 1; j++) {
                if (names[j].compareToIgnoreCase(names[j + 1]) > 0) {
                    // Swap names[j] and names[j + 1]
                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }
    }

    /**
     * method that returns a list of names in format
     *
     * @return the string format of array
     */
    @Override
    public String toString() {
        // Use StringBuilder to concatenate output strings together according to the given format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            sb.append(i + 1).append(". ").append(names[i]);
            if (i != names.length - 1) {
                // Add new line after each name except the last one
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
