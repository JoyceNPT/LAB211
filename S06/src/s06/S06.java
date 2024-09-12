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
public class S06 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            MyCode code = new MyCode();

            // Use the library's getPositiveInteger() method to check for validity
            int n = MyLib.getPositiveInteger("Please enter size of array: ",
                    "The number of elements in the array must be a positive integer.");
            code.inputData(n);

            // Print out the data that the user has entered
            System.out.println("The original array:");
            System.out.println(code.toString());

            // After having input data, we proceed to remove duplicate elements.
            code.removeDuplicate();

            // Print out the edited data
            System.out.println("The array after removing duplicate elements:");
            System.out.println(code.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
