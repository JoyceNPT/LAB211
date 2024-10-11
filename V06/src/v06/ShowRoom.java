/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v06;

import java.util.Arrays;

/**
 * V06 - Car Showroom.
 *
 * @author ThinhNPCE170008
 */
class ExceptionCar extends Exception {

    /**
     * Method used to check and return invalid messages according to each
     * vehicle information
     *
     * @param message Return error message when information is invalid
     */
    public ExceptionCar(String message) {
        super(message);
    }
}

public class ShowRoom {

    /**
     * Method used to access a specific vehicle name
     *
     * @param carName Pass in vehicle name from input
     * @return Return the vehicle name if it is in the showroom
     */
    public Car getCar(String carName) {
        try {
            // Convert the input to uppercase for case-insensitive comparison
            carName = carName.toUpperCase();

            // Iterate through all cars and check if any car name starts with the input
            for (Car car : Car.values()) {
                if (car.name().startsWith(carName)) {
                    return car; // Return the first match found
                }
            }

            // If no car matches, throw IllegalArgumentException
            throw new IllegalArgumentException("No matching car found");

        } catch (IllegalArgumentException e) {
            System.out.println("Car not found.");
            return null; // Return null if car doesn't exist
        }
    }

    /**
     * Method used to check each vehicle information from the user
     *
     * @param car Passes vehicle name data from the user
     * @param color Passes vehicle color data from the user
     * @param day Passes the vehicle purchase date data from the user
     * @param price Passes the vehicle purchase amount data from the user
     * @throws ExceptionCar Returns an error message when the information is
     * invalid
     */
    public Car checkCar(Car car, Color color, Day day, String price) throws ExceptionCar {

        // Check name car
        if (car == null) {
            throw new ExceptionCar("Car type is not valid.");
        }

        // Check color car
        if (color == null || !Arrays.asList(car.getColors()).contains(color)) {
            throw new ExceptionCar("Car color is not valid for the selected car.");
        }

        // Check car buy date
        if (day == null || !Arrays.asList(car.getAvailableDays()).contains(day)) {
            throw new ExceptionCar("Selected day is not valid for the chosen car.");
        }

        // Get the list of fares
        int[] expectedPrice = car.getPrice();
        int actualPrice;

        try {
            actualPrice = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new ExceptionCar("Price must be a valid number.");
        }

        // Check for unpainted car discount
        if (color == Color.NO_COLOR) {
            actualPrice += 100; // Apply discount
        }

        // Check if the actual price is within the expected price range
        if (actualPrice < expectedPrice[0] || actualPrice > expectedPrice[2]) {
            throw new ExceptionCar("Price does not match the selected car.");
        }

        return car;
    }
}
