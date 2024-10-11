/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v06;

import java.util.Scanner;

/**
 * V06 - Car Showroom.
 *
 * @author ThinhNPCE170008
 */
public class V06 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShowRoom showroom = new ShowRoom();

        while (true) {
            System.out.println("===== Showroom Car Program =====");

            // Getting non-empty input for Car Name
            Car car = null;
            while (car == null) {
                System.out.print("Enter car type (AUDI, MERCEDES, BMW): ");
                String carName = sc.nextLine().toUpperCase();

                // Check if the input is empty
                if (carName.isEmpty()) {
                    System.out.println("Car name cannot be empty. Please enter a valid car type.");
                    continue; // Ask for input again
                }

                car = showroom.getCar(carName);
                if (car == null) {
                    System.out.println("Car does not exist in showroom. Please try again.");
                }
            }

            // Getting non-empty input for Car Color
            Color color = null;
            while (color == null) {
                System.out.print("Enter car color (e.g., WHITE, YELLOW, ORANGE, GREEN, BLUE, NO_COLOR): ");
                String carColor = sc.nextLine().toUpperCase();
                color = Color.getColor(carColor);
                if (color == null) {
                    System.out.println("Color is not valid. Please try again.");
                }
            }

            // Getting non-empty input for Price
            int priceValue = -1;
            while (priceValue < 0) {
                System.out.print("Enter the price of the car: ");
                String price = sc.nextLine();
                try {
                    priceValue = Integer.parseInt(price);
                    if (priceValue < 0) {
                        System.out.println("Error: Price must be greater than or equal to zero.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Price must be a valid integer.");
                }
            }

            // Getting non-empty input for Day
            Day day = null;
            while (day == null) {
                System.out.print("Enter the day of purchase (e.g., MONDAY, TUESDAY, WEDNESDAY): ");
                String dayInput = sc.nextLine().toUpperCase();
                day = Day.getDay(dayInput);
                if (day == null) {
                    System.out.println("Day is not valid. Please try again.");
                }
            }

            // Check if the car can be sold
            try {
                showroom.checkCar(car, color, day, String.valueOf(priceValue));
                System.out.println("Car selected successfully: " + car + " with color " + color + " on " + day + " at price " + priceValue);
            } catch (ExceptionCar e) {
                System.out.println("Can't sell Car");
                System.out.println(e.getMessage());
            }

            // Prompting user if they want to search for more cars
            System.out.print("Do you want to find more? (Y/N): ");
            String choice = sc.nextLine().trim().toUpperCase();
            if (!choice.equals("Y")) {
                System.out.println("Exiting program.");
                break;
            }
        }
    }
}
