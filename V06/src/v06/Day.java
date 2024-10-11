/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v06;

/**
 * V06 - Car Showroom.
 *
 * @author ThinhNPCE170008
 */
public enum Day {
    // Initialize dates list
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    /**
     * Method used to access a list of dates
     *
     * @param day Passes in a date from input
     * @return Returns the specified date
     */
    public static Day getDay(String day) {
        try {
            return Day.valueOf(day.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
