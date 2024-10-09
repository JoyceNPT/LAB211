/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s12;

/**
 * S12 - Convert binary, octal and hexadecimal to decimal
 *
 * @author ThinhNPCE170008
 */
public class MyConvert {

    /**
     * Binary to Decimal Conversion Method
     *
     * @param binary Pass binary value from input
     * @return Returns the sum of converted decimal values
     */
    public long biToDec(String binary) {
        long decimal = 0;
        int length = binary.length();

        for (int i = 0; i < length; i++) {
            char bit = binary.charAt(i);
            if (bit == '0' || bit == '1') {
                // Convert each bit to a decimal value
                decimal += (bit - '0') * Math.pow(2, length - 1 - i);
            } else {
                // Invalid character in binary
                return -1;
            }
        }

        return decimal;
    }

    /**
     * Octal to Decimal Conversion Method
     *
     * @param octal Pass octal value from input
     * @return Returns the sum of converted decimal values
     */
    public long octToDec(String octal) {
        long decimal = 0;
        int length = octal.length();

        for (int i = 0; i < length; i++) {
            char digit = octal.charAt(i);
            if (digit >= '0' && digit <= '7') {
                // Convert each octal digit to a decimal value
                decimal += (digit - '0') * Math.pow(8, length - 1 - i);
            } else {
                // Invalid character in octal
                return -1;
            }
        }

        return decimal;
    }

    /**
     * Hexadecimal to Decimal conversion Method
     *
     * @param hex Pass hexadecimal value from input
     * @return Returns the sum of converted decimal values
     */
    public long hexToDec(String hex) {
        long decimal = 0;
        int length = hex.length();

        for (int i = 0; i < length; i++) {
            char digit = hex.charAt(i);
            int value;

            // Check if digit is a valid hexadecimal character (0-9, A-F, a-f)
            if (digit >= '0' && digit <= '9') {
                value = digit - '0';
            } else {
                // Convert both upper and lower case letters to upper case
                value = digit - 'A' + 10;
            }

            decimal += value * Math.pow(16, length - 1 - i);
        }

        return decimal;
    }
}
