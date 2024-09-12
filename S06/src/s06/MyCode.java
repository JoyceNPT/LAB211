/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s06;

/**
 * S06 - Delete duplicate elements in an array.
 *
 * @author ThinhNPCE170008
 */
public class MyCode {

    private int[] array;

    /**
     * Check input for number of elements and whether elements are valid or not
     */
    public void inputData(int n) {

        // Once we have n, we let the created array have a maximum of n elements.
        array = new int[n];

        // Use a for loop to check each element and save it to an array.
        for (int i = 0; i < array.length; i++) {
            // Use the library's getPositiveInteger() method to check for validity
            array[i] = MyLib.getInteger("Element[" + i + "]= ",
                    "You entered the wrong information, please re-enter.");
        }
    }

    /**
     * Method used to delete duplicate elements in an array
     */
    public void removeDuplicate() {
        // Create a temporary array containing unique elements with an initial capacity equal to the original array
        int[] tempArray = new int[array.length];
        int j = 0;  // Use a unique counter variable to use for a new array with unique elements

        // fori loop used to iterate over array
        for (int i = 0; i < array.length; i++) {
            boolean isDuplicate = false;
            // Check if an element in the old array matches an element in the new array
            for (int k = 0; k < j; k++) {
                if (array[i] == tempArray[k]) {
                    isDuplicate = true;
                    break;
                }
            }
            // If it's not a duplicate, add it to the tempArray
            if (!isDuplicate) {
                tempArray[j] = array[i];
                j++;
            }
        }

        // Create a new array of size = j (unique element counter) to bring all filtered elements into the new array
        array = new int[j];
        for (int i = 0; i < j; i++) {
            array[i] = tempArray[i];
        }
    }

    /**
     * Returns a formatted string according to the assignment requirements
     *
     * @return the string format of array
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            str += array[i] + "\t";
        }
        return str;
    }
}
