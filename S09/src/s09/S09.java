/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s09;

import java.util.Scanner;

/**
 * S09 - Program to insert new element into an existing array.
 *
 * @author ThinhNPCE170008
 */
public class S09 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the size of the array
        int size = MyLib.getPositiveInteger("Please enter size of array: ", "The number of elements in the array must be a positive integer.");

        MyCode code = new MyCode(size);

        // Get the elements of the array
        for (int i = 0; i < size; i++) {
            int element = MyLib.getInteger("Element[" + i + "]= ", "Incorrect integer, please re-enter.");
            code.addElement(element);  // addElement automatically inserts in sorted order
        }

        // Display the sorted array
        System.out.println("The array after sorting:");
        code.displayArray();

        // Input the new element
        int newValue = MyLib.getInteger("Please enter new value: ", "Incorrect integer, please re-enter.");

        // Insert the new element and display the new array
        code.addElement(newValue);
        System.out.println("New array:");
        code.displayArray();
    }
}
