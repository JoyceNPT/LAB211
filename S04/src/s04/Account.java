/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s04;

import java.text.SimpleDateFormat;

/**
 * S04 - Write a login function uses MD5 encryption for passwords (separate from
 * FPT Web mail software Project.
 *
 * @author ThinhNPCE170008
 */
public class Account {

    private String username;
    private String password; // Encrypted password
    private String name;
    private String phone;
    private String email;
    private String address;
    private String dob;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Account information initialization method
     *
     * @param username initialization username
     * @param password initialization password
     * @param name initialization name
     * @param phone initialization phone
     * @param email initialization email
     * @param address initialization address
     * @param dob initialization date of birth
     */
    public Account(String username, String password, String name, String phone, String email, String address, String dob) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
    }

    /**
     * Username access method
     *
     * @return Returns the specified username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Password access method
     *
     * @return Returns the specified password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Password editing method
     *
     * @param password Enter specified password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Name access method
     *
     * @return Returns the specified name
     */
    public String getName() {
        return name;
    }

    /**
     * Email access method
     *
     * @return Returns the specified email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Email editing method
     *
     * @param email Enter specified email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Address access method
     *
     * @return Returns the specified address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Address editing method
     *
     * @param address Enter specified address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Date of birth access method
     *
     * @return Returns the specified date of birth
     */
    public String getDob() {
        return dob;
    }

    /**
     * Date of birth editing method
     *
     * @param dob Enter specified date of birth
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * Phone access method
     *
     * @return Returns the specified phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Phone of birth editing method
     *
     * @param phone Enter specified phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Method of returning account information
     *
     * @return Returns account information
     */
    @Override
    public String toString() {
        return "Account{username='" + username + "', name='" + name + "', phone='" + phone + "', email='" + email + "'}";
    }
}
