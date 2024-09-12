/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s02;

import java.util.Scanner;

/**
 * S02 - String Array Manipulations.
 *
 * @author ThinhNPCE170008
 */
public class MyLib {

    static Scanner sc = new Scanner(System.in);

    /**
     * Method to check if input is a positive integer or not
     *
     * @param msg Print out a message asking the user to enter a positive
     * integer
     * @param errorMsg Print out an error message and ask the user to re-enter
     * it
     * @return Returns the positive integer that meets the requirement
     */
    public static int getPositiveInteger(String msg, String errorMsg) {
        int n = 0;
        boolean flag = true;
        do {
            // Use try catch to catch exception if user input is not positive integer
            try {
                flag = true;
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                // Check if user input is a non-negative integer, if so set flag to false to ask user to re-enter
                if (n <= 0) {
                    System.out.println(errorMsg);
                    flag = false;
                }
            } catch (Exception e) {
                //Use try catch exception to catch errors from non-integer input
                System.out.println(errorMsg);
                flag = false;
            }
        } while (!flag);

        return n;
    }

    /**
     * Method used to check valid first and last name
     *
     * @param msg Print out a message asking the user to enter name
     * @param errorMsg Print out an error message and ask the user to re-enter
     * it
     * @return Returns the name that meets the requirement
     */
    public static String getNameUser(String msg, String errorMsg) {
        String name = null;
        boolean flag = false;

        // Use a do while loop to prompt the user to re-enter input if incorrect.
        do {
            try {
                System.out.print(msg);
                name = sc.nextLine();
                // Use regex ^[a-zA-Z\\s]+$ to check name validity
                // Also combined with isEmpty to check if the input data is empty.
                if (name != null && !name.isEmpty() && name.matches("[a-zA-Z]+")) {
                    flag = true;
                } else {
                    System.out.println(errorMsg);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println(errorMsg + " " + e.getMessage());
                flag = false;
            }
        } while (!flag);

        return name;
    }

    /**
     * Method used to check if input is an integer
     *
     * @param msg Print out a message asking the user to enter a positive
     * integer
     * @param errorMsg Print out an error message and ask the user to re-enter
     * it
     * @return Returns the integer that meets the requirement
     */
    public static int getInteger(String msg, String errorMsg) {
        int n = 0;
        boolean flag = true;
        do {
            // Use try catch to catch exception if user input is not integer
            try {
                flag = true;
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                // Use try catch exception to catch errors from non-integer input
                System.out.println(errorMsg);
                flag = false;
            }
        } while (!flag);

        return n;
    }
}
