/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * V04 - Simple Slot Machine.
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
                // Use regex "[a-zA-Z]+" to check name validity
                // Also combined with isEmpty to check if the input data is empty.
                if (name != null && !name.isEmpty() && name.matches("[a-zA-Z]+")) {
                    flag = true;
                } else {
                    System.out.println(errorMsg);
                    flag = false;
                }
            } catch (Exception e) {
                // Use try catch exception to catch errors from input
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

    /**
     * Method used to check if input is an float
     *
     * @param msg Print out a message asking the user to enter a positive float
     * @param errorMsg Print out an error message and ask the user to re-enter
     * it
     * @return Returns the float that meets the requirement
     */
    public static float getPositiveFloat(String msg, String errorMsg) {
        float n = 0.0f;
        boolean flag = true;
        do {
            // Use try catch to catch exception if user input is not float
            try {
                flag = true;
                System.out.print(msg);
                String input = sc.nextLine();

                if (!input.equals(input.trim())) {
                    System.out.println(errorMsg);
                    flag = false;
                    continue;
                }
                n = Float.parseFloat(input);

                // Check if user input is a non-negative float, if so set flag to false to ask user to re-enter
                if (n <= 0.0) {
                    System.out.println(errorMsg);
                    flag = false;
                }
            } catch (Exception e) {
                // Use try catch exception to catch errors from non-float input
                System.out.println(errorMsg);
                flag = false;
            }
        } while (!flag);

        return n;
    }

    /**
     * Method used to check conditional input selection
     *
     * @param msg Prints a message asking the user to enter a choice as required
     * by the program.
     * @param errorMsg Prints a syntax error or invalid input message, asking
     * the user to re-enter
     * @param start As a program condition, the user can select from this range
     * to the end range.
     * @param end This is the end of the program allowed
     * @return Returns the matching input value
     */
    public static int getChoiceConditional(String msg, String errorMsg, int start, int end) {
        int n = 0;
        boolean flag = true;
        do {
            // Use try catch to catch exception if user input does not match the request
            try {
                flag = true;
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                // Check the input to see if it is correct according to the requirements.
                if (n < start || n > end) {
                    System.out.println(errorMsg);
                    flag = false;
                }
            } catch (Exception e) {
                // In addition to required imports, other exceptions should also be checked.
                System.out.println(errorMsg);
                flag = false;
            }
        } while (!flag);

        return n;
    }

    /**
     * Method to check if a string contains only letters
     *
     * @param msg Print out a message asking the user to enter the meaning of
     * the word.
     * @param errorMsg Print out an error message that the string does not
     * match, asking the user to re-enter it.
     * @return Returns the value that matches the request
     */
    public static String getPara(String msg, String errorMsg) {
        String name = null;
        boolean flag = false;

        // Use a do while loop to prompt the user to re-enter input if incorrect.
        do {
            try {
                System.out.print(msg);
                name = sc.nextLine();

                // Use the manual method via startsWith and endsWith to 
                // check for whitespace at the beginning and end of the string
                if (name.startsWith(" ") || name.endsWith(" ")) {
                    System.out.println(errorMsg);
                    flag = false;
                    continue;
                }
                // Use regex "^[a-zA-Z]+(\\s[a-zA-Z]+)*$" to check name validity
                if (name != null && !name.isEmpty() && name.matches("^[a-zA-Z;]+(\\s[a-zA-Z;]+)*$")) {
                    flag = true;
                } else {
                    System.out.println(errorMsg);
                    flag = false;
                }
            } catch (Exception e) {
                // Use try catch exception to catch errors from input
                System.out.println(errorMsg + " " + e.getMessage());
                flag = false;
            }
        } while (!flag);

        return name;
    }

    /**
     * Method of checking student input code
     *
     * @param msg Print out a message asking the user to enter the meaning of
     * the student code.
     * @param errorMsg Print out an error message that the string does not
     * match, asking the user to re-enter it.
     * @return Returns valid student code
     */
    public static String getValidStudentCode(String msg, String errorMsg) {
        while (true) {
            System.out.print(msg);
            String studentCode = sc.nextLine();
            // Expression to check student code according to required standard format
            if (studentCode.matches("[a-zA-Z]{2}\\d{4}")) {
                String lastFourDigits = studentCode.substring(studentCode.length() - 4);
                if (lastFourDigits.equals("0000")) {
                    System.out.println(errorMsg);
                } else {
                    return studentCode;
                }
            } else {
                System.out.println(errorMsg);
            }
        }
    }

    /**
     * Method to check valid input date of birth
     *
     * @param msg Print out a message asking the user to enter the meaning of
     * the birth.
     * @param errorMsg Print out an error message that the string does not
     * match, asking the user to re-enter it.
     * @return Returns valid birth
     */
    public static String getValidBirth(String msg, String errorMsg) {
        Locale.setDefault(Locale.ENGLISH);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        sdf.setLenient(false); // Ensure strict date format checking

        Date birthDate = null;

        while (true) {
            System.out.print(msg);
            String date = sc.nextLine();

            // Check if the date matches the format
            try {
                birthDate = sdf.parse(date);

                // Check if age is between 18 and 100
                if (isAgeValid(birthDate)) {
                    return date; // Valid date, return it
                } else {
                    System.out.println(errorMsg + " . Please try again.");
                }
            } catch (ParseException e) {
                System.out.println(errorMsg + " . Please try again.");
            }
        }
    }

    /**
     * Method used to check if age is 18 or older
     *
     * @param birthDate Get date of birth from user to check validity
     * @return Returns the result of checking if the age is valid.
     */
    private static boolean isAgeValid(Date birthDate) {
        // Get the current date
        Calendar today = Calendar.getInstance();

        // Get the birth date in Calendar
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);

        // Calculate the age
        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

        // If today's date is before the birth date in the current year, subtract one year from the age
        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        // Return true if age is between 18 and 100
        return age >= 18 && age <= 100;
    }
}
