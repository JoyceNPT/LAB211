/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v01;

import java.util.Scanner;

/**
 * V01 - Simulate ATM’s operation
 *
 * @author ThinhNPCE170008
 */
public class V01 {

    /**
     * The main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyATM atm = new MyATM();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        boolean loggedIn = false;

        while (!exit) {
            // Program menu
            System.out.println("\n=== ATM System ===");
            System.out.println("1. Register Account");
            System.out.println("2. Login");
            if (loggedIn) {
                System.out.println("3. Withdraw Money");
                System.out.println("4. Transfer Money");
            }
            System.out.println("5. Exit");

            int choice = MyLib.getChoiceConditional("Please choose an option: ", "Invalid selection, please select again", 1, 5);

            try {
                switch (choice) {
                    case 1:
                        // Gathering inputs for registration
                        String account = MyLib.getAccountDigit("Enter account number (14 digits): ", "Invalid account, please re-enter", 14);

                        if (atm.accountExists(account)) {
                            System.out.println("Account already exists! Please try again with a different account number.");
                        } else {

                            String pin = MyLib.getAccountDigit("Enter PIN (6 digits): ", "Invalid pin, please re-enter", 6);

                            String name = MyLib.getPara("Enter account name: ", "Your account name is invalid, please re-enter.");

                            double balance = MyLib.getPositiveDouble("Enter initial balance: ", "Invalid input or amount, please re-enter");

                            String moneyType = MyLib.getMoney("Enter money type (e.g., USD, VND): ", "Invalid currency, please re-enter");

                            atm.registerAccount(account, pin, name, balance, moneyType);
                        }
                        break;

                    case 2:
                        // Gathering inputs for login
                        String loginAccount = MyLib.getAccountDigit("Enter account number (14 digits): ", "Invalid account, please re-enter", 14);

                        String loginPin = MyLib.getAccountDigit("Enter PIN (6 digits): ", "Invalid pin, please re-enter", 6);

                        atm.login(loginAccount, loginPin);
                        loggedIn = atm.isLoggedIn(); // Update login status
                        break;

                    case 3:
                        // Gathering inputs for withdrawal
                        if (!loggedIn) {
                            System.out.println("Please login first.");
                            break;
                        }

                        // Check balance before allowing withdrawal
                        double currentBalance = atm.getBalance();
                        if (currentBalance <= 0) {
                            System.out.println("Your account has insufficient funds (balance is 0). Withdrawal not possible.");
                            break;
                        }

                        double withdrawAmount = MyLib.getPositiveDouble("Enter amount to withdraw: ", "Invalid input or amount, please re-enter");

                        atm.withdrawMoney(withdrawAmount);
                        break;

                    case 4:
                        // Gathering inputs for money transfer
                        if (!loggedIn) {
                            System.out.println("Please login first.");
                            break;
                        }

                        // Check balance before allowing transfer
                        currentBalance = atm.getBalance();
                        if (currentBalance <= 0) {
                            System.out.println("Your account has insufficient funds (balance is 0). Transfer not possible.");
                            break;
                        }

                        String destinationAccount = MyLib.getAccountDigit("Enter destination account number (14 digits): ", "Invalid account, please re-enter", 14);

                        double transferAmount = MyLib.getPositiveDouble("Enter amount to transfer: ", "Invalid input or amount, please re-enter");

                        atm.transferMoney(destinationAccount, transferAmount);
                        break;

                    case 5:
                        // Exit program
                        exit = true;
                        System.out.println("Thank you for using our ATM service.");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
