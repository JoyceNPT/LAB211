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
public class S02 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            MyCal myCal = new MyCal();

            // method to input name and number of names. Then check the input
            int n = MyLib.getPositiveInteger("Enter the value of n\n",
                    "Number of element must be a positive integer");
            myCal.inputData(n);

            // Print unsorted names
            System.out.println("List input name:");
            System.out.println(myCal.toString());

            // Sort names in ascending alphabetical order using bubble sort algorithm
            myCal.bubbleSort();

            // Print sorted names
            System.out.println("List sort name:");
            System.out.print(myCal.toString());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
