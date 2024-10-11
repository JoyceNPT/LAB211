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
public enum Car {
    // Initialize showroom vehicle information list
    AUDI(new int[]{3000, 4500, 5500}, new Color[]{Color.WHITE, Color.YELLOW, Color.ORANGE, Color.NO_COLOR}, new Day[]{Day.FRIDAY, Day.SUNDAY, Day.MONDAY}),
    MERCEDES(new int[]{5000, 6000, 8500}, new Color[]{Color.GREEN, Color.BLUE, Color.PURPLE, Color.NO_COLOR}, new Day[]{Day.TUESDAY, Day.SATURDAY, Day.WEDNESDAY}),
    BMW(new int[]{2500, 3000, 3500}, new Color[]{Color.PINK, Color.RED, Color.BROWN, Color.NO_COLOR}, new Day[]{Day.MONDAY, Day.SUNDAY, Day.THURSDAY});

    private final int[] prices;
    private final Color[] colors;
    private final Day[] availableDays;

    /**
     * Constructor is used to retrieve data from program and user.
     *
     * @param prices Pass in the money list
     * @param colors Pass in the color list
     * @param availableDays Pass in the days list
     */
    Car(int[] prices, Color[] colors, Day[] availableDays) {
        this.prices = prices;
        this.colors = colors;
        this.availableDays = availableDays;
    }

    /**
     * Method used to access the list of coins
     *
     * @return Returns the specified amount
     */
    public int[] getPrice() {
        return prices;
    }

    /**
     * Method used to access the color list
     *
     * @return Returns the specified color
     */
    public Color[] getColors() {
        return colors;
    }

    /**
     * Method used to access the list of vehicle sale dates
     *
     * @return Returns the specified date
     */
    public Day[] getAvailableDays() {
        return availableDays;
    }
}
