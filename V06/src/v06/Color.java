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
public enum Color {
    // Initialize colors list
    WHITE, YELLOW, ORANGE, GREEN, BLUE, PURPLE, PINK, RED, BROWN, NO_COLOR;

    /**
     * Method used to access a list of colors
     *
     * @param color Passes in a color from input
     * @return Returns the specified color
     */
    public static Color getColor(String color) {
        if (color.equalsIgnoreCase("no color")) {
            return NO_COLOR;
        }
        try {
            return Color.valueOf(color.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
