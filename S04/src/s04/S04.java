/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s04;

import java.util.Scanner;

/**
 * S04 - Write a login function uses MD5 encryption for passwords (separate from
 * FPT Web mail software Project.
 *
 * @author ThinhNPCE170008
 */
public class S04 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyCode code = new MyCode();

        int choice;

        while (true) {
            // Program menu
            System.out.println("============ Login Program =========");
            System.out.println("1. Add User");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            choice = MyLib.getChoiceConditional("Please choose one option: ", "Invalid selection, please re-enter", 1, 3);

            switch (choice) {
                case 1:  // Add User
                    System.out.println("---------- Add User --------");

                    String username;
                    while (true) {
                        username = MyLib.getNameUser("Username: ", "Invalid username, please re-enter.");

                        // Check if the username already exists
                        if (code.isUsernameTaken(username)) {
                            System.out.println("Error: Username is already taken, please choose a different username.");
                        } else {
                            break;  // Username is available, proceed
                        }
                    }

                    String password;
                    String repassword;
                    while (true) {
                        System.out.print("Password: ");
                        password = sc.nextLine().trim();
                        System.out.print("Re-enter password: ");
                        repassword = sc.nextLine().trim();

                        // Check if the password already exists
                        if (password == null || password.isEmpty()) {
                            System.out.println("Error: Password or Re-enter password cannot be empty.");
                        } // Check if the passwords match
                        else if (!password.equals(repassword)) {
                            System.out.println("Error: Passwords do not match.");
                        } else {
                            break;  // Password confirmed, exit loop
                        }
                    }

                    String name = MyLib.getPara("Name: ", "Invalid name, please re-enter");

                    String phone;
                    while (true) {
                        System.out.print("Phone: ");
                        phone = sc.nextLine();

                        // Check if the phone is valid
                        if (!code.isValidPhone(phone)) {
                            System.out.println("Error: Phone number must be 10 digits.");
                        } else {
                            break;
                        }
                    }

                    String email;
                    while (true) {
                        System.out.print("Email: ");
                        email = sc.nextLine();

                        // Check if the email is valid
                        if (!MyLib.validateEmail(email)) {
                            System.out.println("Error: Invalid email format.");
                        } else {
                            break;
                        }
                    }

                    String address;
                    while (true) {
                        address = MyLib.getPara("Address: ", "Invalid address, please re-enter.");

                        // Check if the address is valid
                        if (address == null || address.isEmpty()) {
                            System.out.println("Error: Invalid address.");
                        } else {
                            break;
                        }
                    }

                    String dob;
                    while (true) {
                        System.out.print("DOB (dd/MM/yyyy): ");
                        dob = sc.nextLine();

                        // Check if the date of birth is valid
                        if (!code.isValidDate(dob)) {
                            System.out.println("Error: Date of Birth must be in dd/MM/yyyy format.");
                        } else {
                            break;
                        }
                    }

                    try {
                        int accountId = code.addAccount(username, password, name, phone, email, address, dob);
                        System.out.println("Account created successfully. Your ID: " + accountId);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:  // Login
                    System.out.println("------------- Login ----------------");

                    System.out.print("Account: ");
                    String loginUsername = sc.nextLine().toLowerCase();

                    System.out.print("Password: ");
                    String loginPassword = sc.nextLine();

                    // Check if the login account is correct or not
                    if (!code.login(loginUsername, loginPassword)) {
                        System.out.println("Account or Password is incorrect.");
                    } else {
                        Account account = code.findAccountByUsername(loginUsername);
                        System.out.println("------------ Welcome -----------");
                        System.out.println("Hi " + account.getName() + ", do you want to change your password now? Y/N:");
                        String changePassword = sc.nextLine();

                        // If the user chooses to change the password, the user is required to re-enter the old password.
                        if (changePassword.equalsIgnoreCase("Y")) {
                            boolean correctOldPassword = false;
                            while (!correctOldPassword) {
                                System.out.println("Old password: ");
                                String oldPassword = sc.nextLine().trim();

                                if (account.getPassword().equals(code.encryptPassword(oldPassword))) {
                                    correctOldPassword = true;

                                    boolean passwordsMatch = false;
                                    while (!passwordsMatch) {
                                        System.out.print("New password: ");
                                        String newPassword = sc.nextLine().trim();

                                        // Check if the new password is null or empty
                                        if (newPassword == null || newPassword.isEmpty()) {
                                            System.out.println("Error: New password cannot be empty. Please re-enter.");
                                            continue;  // Go back to the start of the loop
                                        }

                                        System.out.print("Re-enter new password: ");
                                        String renewPassword = sc.nextLine().trim();

                                        // Check if the re-entered new password is null or empty
                                        if (renewPassword == null || renewPassword.isEmpty()) {
                                            System.out.println("Error: Re-entered password cannot be empty. Please re-enter.");
                                            continue;  // Go back to the start of the loop
                                        }

                                        // Check if both passwords match
                                        if (newPassword.equals(renewPassword)) {
                                            account.setPassword(code.encryptPassword(newPassword));
                                            System.out.println("Password changed successfully.");
                                            passwordsMatch = true;  // Exit the loop when successful
                                        } else {
                                            System.out.println("Passwords do not match.");
                                        }
                                    }
                                } else {
                                    System.out.println("Old password is incorrect.");
                                }
                            }
                        }
                    }
                    break;
                case 3:  // Exit
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
