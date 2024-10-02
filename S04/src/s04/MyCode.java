/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s04;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * S04 - Write a login function uses MD5 encryption for passwords (separate from
 * FPT Web mail software Project.
 *
 * @author ThinhNPCE170008
 */
public class MyCode {

    private List<Account> accounts = new ArrayList<>();

    /**
     * How to check for duplicate usernames
     *
     * @param username Passing parameters from input
     * @return Returns true if the username already exists
     */
    public boolean isUsernameTaken(String username) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                return true;  // Username is taken
            }
        }
        return false;  // Username is available
    }

    /**
     * This method is used to check valid phone number (by Vietnam number)
     *
     * @param phone Passing parameters from input
     * @return Returns true if phone number is valid
     */
    public boolean isValidPhone(String phone) {
        if (phone.length() == 10) {
            // ^0[1-9] Make sure the first number is 0, followed by numbers 1-9
            // (?=.*[1-9].*[1-9].*[1-9]) Make sure that in the last 8 numbers, there are at least 3 arbitrary non-zero digits
            // [0-9]{8} Make sure there are 10 numbers in the string and the remaining numbers are allowed from 0-9
            String phoneRegex = "^0[1-9](?=.*[1-9].*[1-9].*[1-9])[0-9]{8}$";
            return phone.matches(phoneRegex);
        } else {
            return false;
        }
    }

    /**
     * This method is used to check for a valid date of birth.
     *
     * @param dob Passing parameters from input
     * @return Returns true if date of birth is valid
     */
    public boolean isValidDate(String dob) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);  // Ensure strict date parsing
        try {
            sdf.parse(dob);  // Try parsing the date
            return true;
        } catch (ParseException e) {
            return false;  // Invalid date format
        }
    }

    /**
     * This method is used to save the checked information from the input.
     *
     * @param username pass in a valid username method
     * @param password pass in a valid password method
     * @param name pass in a valid name method
     * @param phone pass in a valid phone method
     * @param email pass in a valid email method
     * @param address pass in a valid address method
     * @param dob pass in a valid date of birth method
     * @return Returns ID by size of list
     */
    public int addAccount(String username, String password, String name, String phone, String email, String address, String dob) {
        String encryptedPassword = encryptPassword(password);
        Account account = new Account(username.toLowerCase(), encryptedPassword, name, phone, email, address, dob);
        accounts.add(account);
        return accounts.size();  // Return ID (index in the list for simplicity)
    }

    /**
     * Method used to check account when user logs in
     *
     * @param username Passing parameters from input
     * @param password Passing parameters from input
     * @return Returns true if the information is correct
     */
    public boolean login(String username, String password) {
        Account account = findAccountByUsername(username.toLowerCase());
        if (account != null && account.getPassword().equals(encryptPassword(password))) {
            return true;
        }
        return false;
    }

    /**
     * How to check for duplicate usernames
     *
     * @param username Passing parameters from input
     * @return Returns true if the username is correct
     */
    public Account findAccountByUsername(String username) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                return acc;
            }
        }
        return null;
    }

    /**
     * User account password encryption method
     *
     * @param password Passing parameters from input
     * @return Returns the encrypted password string
     */
    public String encryptPassword(String password) {
        try {
            // MD5 encryption will encrypt a 16 byte string
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes()); // Convert password string to hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * How to access the account list
     *
     * @return Returns the specified account
     */
    public List<Account> getAccounts() {
        return accounts;
    }
}
