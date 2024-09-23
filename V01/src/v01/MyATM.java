/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * V01 - Simulate ATM’s operation
 *
 * @author ThinhNPCE170008
 */
public class MyATM {

    private String currentAccount = null; // Holds the currently logged in account
    private String accountFile = "AccountInfo.txt";
    private String transactionFile = "TransactionLogs.txt";

    /**
     * Methods used to check for duplicate accounts
     *
     * @param account Pass the input account number string to check
     * @return Returns the new account number if it does not already exist.
     * @throws IOException Throws exception if file cannot be read
     */
    public boolean accountExists(String account) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(accountFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] accountData = line.split(","); // Get the account number available in the library and check it with the input
                if (accountData[0].trim().equals(account.trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method used to save and write account information to a file
     *
     * @param account Account number from input
     * @param pin Account pin code from input
     * @param name Account holder name from input
     * @param balance Account Initialization Amount
     * @param moneyType Account currency
     * @throws IOException Throws an exception if writing information to file
     * fails
     */
    public void registerAccount(String account, String pin, String name, double balance, String moneyType) throws IOException {
        // Write account information to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(accountFile, true))) {
            writer.write(account + "," + pin + "," + name.toUpperCase() + "," + balance + "," + moneyType);
            writer.newLine();
            System.out.println("Account successfully registered!");
        }
    }

    /**
     * Method used to log into the program
     *
     * @param account Account number from input
     * @param pin Account pin code from input
     * @throws IOException Throws an exception if reading data from the file
     * fails
     */
    public void login(String account, String pin) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(accountFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] accountData = line.split(","); // Read the account number and pin code of the account to check
                if (accountData[0].trim().equals(account.trim()) && accountData[1].equals(pin)) {
                    currentAccount = account;
                    System.out.println("Login successful!");
                    return;
                }
            }
        }
        System.out.println("Invalid account number or PIN!");
    }

    /**
     * How to check login before using withdrawal and transfer money
     *
     * @return Returns the login account if the user has successfully logged in.
     */
    public boolean isLoggedIn() {
        return currentAccount != null;
    }

    /**
     * Check balance from user account before using function
     *
     * @return Returns the current balance of an account
     * @throws IOException Throws an exception if an error occurs while reading
     * data
     */
    public double getBalance() throws IOException {
        if (currentAccount == null) {
            return -1; // Not logged in
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(accountFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] accountData = line.split(",");
                if (accountData[0].trim().equals(currentAccount.trim())) {
                    return Double.parseDouble(accountData[3]);
                }
            }
        }
        return -1; // Account not found
    }

    /**
     * Methods used to withdraw money at ATMs
     *
     * @param amount Enter the amount to withdraw from the input
     * @throws IOException Throws an exception if reading and writing data from
     * file fails
     */
    public void withdrawMoney(double amount) throws IOException {
        // Check if the user is logged in to the program
        if (currentAccount == null) {
            System.out.println("Please login first.");
            return;
        }

        File tempFile = new File("temp.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(accountFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean updated = false;
            while ((line = reader.readLine()) != null) {
                String[] accountData = line.split(",");
                if (accountData[0].trim().equals(currentAccount.trim())) {
                    double balance = Double.parseDouble(accountData[3]); // Extract account balance and compare with withdrawal amount

                    // Check if the balance is 0 or insufficient
                    if (balance <= 0) {
                        System.out.println("Your account has insufficient funds (balance is 0). Withdrawal not possible.");
                        return;
                    }

                    if (balance >= amount) {
                        balance -= amount;
                        accountData[3] = String.valueOf(balance);
                        updated = true; // Account found and amount updated successfully
                        System.out.println("Withdrawal successful! New balance: " + balance);

                        // Log the withdrawal
                        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter(transactionFile, true))) {
                            logWriter.write(currentAccount + " withdrew " + amount);
                            logWriter.newLine();
                        }
                    } else {
                        System.out.println("Insufficient balance.");
                        return;
                    }
                }
                writer.write(String.join(",", accountData));
                writer.newLine();
            }

            if (!updated) {
                System.out.println("Account not found.");
            }
        }

        // Replace old account file with updated data
        File oldFile = new File(accountFile);
        oldFile.delete();
        tempFile.renameTo(oldFile);
    }

    /**
     * Method used to transfer money at ATM
     *
     * @param destinationAccount The account number the user wants to transfer
     * money to
     * @param amount Amount the user needs to transfer
     * @throws IOException Throws an exception if reading and writing data from
     * file fails
     */
    public void transferMoney(String destinationAccount, double amount) throws IOException {
        // Check if the user is logged in to the program
        if (currentAccount == null) {
            System.out.println("Please login first.");
            return;
        }

        boolean destinationExists = false;
        boolean transferSuccessful = false;

        File tempFile = new File("temp.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(accountFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] accountData = line.split(","); // Extract destination account balance and compare with transfer order
                if (accountData[0].trim().equals(destinationAccount.trim())) {
                    destinationExists = true;
                    // Update the destination account balance
                    double destBalance = Double.parseDouble(accountData[3]);
                    accountData[3] = String.valueOf(destBalance + amount);
                }

                // Extract current account balance and compare with transfer order
                if (accountData[0].trim().equals(currentAccount.trim())) {
                    double balance = Double.parseDouble(accountData[3]);

                    // Check if balance is 0
                    if (balance <= 0) {
                        System.out.println("Your account has insufficient funds (balance is 0). Transfer not possible.");
                        return;
                    }

                    if (balance >= amount) {
                        balance -= amount;
                        // Update the current account balance
                        accountData[3] = String.valueOf(balance);
                        transferSuccessful = true;
                        System.out.println("Transfer successful! New balance: " + balance);

                        // Log the transfer
                        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter(transactionFile, true))) {
                            logWriter.write(currentAccount + " transferred " + amount + " to " + destinationAccount);
                            logWriter.newLine();
                        }
                    } else {
                        System.out.println("Insufficient balance.");
                        return;
                    }
                }

                writer.write(String.join(",", accountData));
                writer.newLine();
            }

            if (!destinationExists) {
                System.out.println("Destination account does not exist.");
            }
        }

        // Replace old account file with updated data
        File oldFile = new File(accountFile);
        oldFile.delete();
        tempFile.renameTo(oldFile);
    }
}
