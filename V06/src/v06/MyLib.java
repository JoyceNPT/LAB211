/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v06;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * V06 - Car Showroom.
 *
 * @author ThinhNPCE170008
 */
public class MyLib {

    static Scanner sc = new Scanner(System.in);

    // List of valid colors
    private static final List<String> validColors = Arrays.asList(
            "WHITE", "YELLOW", "ORANGE", "GREEN", "BLUE", "PURPLE", "PINK", "RED", "BROWN", "NO_COLOR"
    );

    // List of valid days
    private static final List<String> validDays = Arrays.asList(
            "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"
    );

    /**
     * Method to check if the color is valid
     *
     * @param msg Pass on user notifications
     * @return Returns the correct color format
     */
    public static String checkColor(String msg) {
        String color;

        while (true) {
            System.out.print(msg);
            color = sc.nextLine().trim().toUpperCase();

            if (color.equalsIgnoreCase("NO COLOR")) {
                return "NO_COLOR";
            }

            // Check if the color contains spaces or special characters
            if (color.contains("  ") || !color.matches("[A-Z_\\s]+")) {
                System.out.println("Error: Color contains invalid characters (letters only). Please re-enter.");
                continue;
            }

            // Check if the color is in the list of valid colors
            if (!validColors.contains(color)) {
                System.out.println("Error: Color not recognized. Please re-enter.");
            } else {
                // If valid, break out of the loop
                break;
            }
        }

        return color;
    }

    /**
     * Method to check if the day is valid
     *
     * @param smg Pass on user notifications
     * @return Returns the correct day format
     */
    public static String checkDay(String smg) {
        String day;

        while (true) {
            System.out.print(smg);
            day = sc.nextLine().trim().toUpperCase();

            // Check if the input contains spaces or special characters
            if (day.contains(" ") || !day.matches("[A-Z]+")) {
                System.out.println("Error: Day contains invalid characters. Please re-enter.");
                continue;
            }

            // Check if the input is a valid day
            if (!validDays.contains(day)) {
                System.out.println("Error: Day not recognized. Please re-enter.");
            } else {
                // If valid, break out of the loop
                break;
            }
        }

        return day;
    }
}
