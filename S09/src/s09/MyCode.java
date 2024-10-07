/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s09;

import java.util.ArrayList;

/**
 * S09 - Program to insert new element into an existing array.
 *
 * @author ThinhNPCE170008
 */
public class MyCode {

    private ArrayList<Integer> array;  // ArrayList to handle dynamic insertion

    /**
     * Initialize the size of ArrayList using constructor
     *
     * @param size Size for ArrayList
     */
    public MyCode(int size) {
        this.array = new ArrayList<>(size);
    }

    /**
     * Method to add new element and at the same time sort it in the correct
     * order
     *
     * @param newValue Pass new element from input
     */
    public void addElement(int newValue) {
        if (array.isEmpty()) {
            array.add(newValue);  // First element, no need to check anything
        } else {
            // Find the correct position to insert the new value
            int position = 0;
            while (position < array.size() && array.get(position) < newValue) {
                position++;
            }
            array.add(position, newValue);  // Insert new value in its correct position
        }
    }

    /**
     * Print out a string of elements formatted as required by the exercise.
     */
    public void displayArray() {
        for (int value : array) {
            System.out.print(value + "   ");
        }
        System.out.println();  // Move to the next line after printing all elements
    }
}
