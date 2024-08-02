
package org.example;


import org.example.account.AccountService;
import org.example.user.User;
import org.example.user.UserService;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        UserService userService = new UserService();
        userHints(input, userService);
    }

    public static void userHints(Scanner input, UserService userService) {
        userService.generateUserId();
        int choice;
        User loggedInUser = null;
        System.out.println("Welcome to the Banking system!");

        do {
            System.out.println("1-) Sign Up\n2-) Log In\n3-) Exit\nPlease choose your transaction: ");
            choice = input.nextInt();

            while (choice != 1 && choice != 2 && choice != 3) {
                System.out.println("Please enter a valid value (1, 2 or 3): ");
                userHints(input, userService);
                choice = input.nextInt();

            }

            switch (choice) {
                case 1:
                    System.out.print("Enter full name: ");
                    String fullName = input.nextLine();
                    input.nextLine();
                    System.out.print("Enter password: ");
                    String password = input.nextLine();
                    System.out.print("Enter email: ");
                    String email = input.nextLine();
                    System.out.print("Enter age: ");
                    int age = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter address: ");
                    String address = input.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = input.nextLine();
                    System.out.print("Enter identity number: ");
                    String identityNumber = input.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = input.nextDouble();
                    input.nextLine();
                    userService.signUp(fullName,
                            password,
                            email,
                            age,
                            address,
                            phoneNumber,
                            identityNumber,
                            salary);
                    break;
                case 2:

                    System.out.println("IdentityNumber :  ");
                    input.nextLine();
                    identityNumber = input.nextLine();
                    System.out.println("Password: ");
                    password = input.nextLine();
                    loggedInUser = userService.logIn(identityNumber, password);
                    if (loggedInUser != null) {
                        menu(input, userService);
                    } else {
                        userHints(input, userService);
                    }
                    break;

                case 3:
                    System.out.println("Logging out of the banking system...");
                    System.exit(0);
                    break;
            }
        } while (choice != 2);
    }


    public static void printMenu() {
        System.out.println("------------");
        System.out.println(" MENU: ");
        System.out.println("------------");
        System.out.println("1-) Delete User");
        System.out.println("2-) Update User");
        System.out.println("3-) User Information");
        System.out.println("4-) Create Account");
        System.out.println("5-) List Account");
        System.out.println("6-) Check Balance");
        System.out.println("7-) Delete Account");
        System.out.println("8-) Withdraw Money");
        System.out.println("9-) Deposit Money");
        System.out.println("10-) Taking Credit");
        System.out.println("11-) Credit Payment");
        System.out.println("12-) Account History");
        System.out.println("13-) Credit Information");
        System.out.println("14-) Exit");
        System.out.println("Please choose your transaction: ");
    }

    public static void menu(Scanner input, UserService userService) {
        AccountService accountService = new AccountService(userService);
        int choice, userId;
        long accountNumber;
        float amount;
        String password, email, address, phoneNumber;
        double salary;
        do {
            printMenu();
            choice = input.nextInt();
            while (choice < 1 || choice > 14) {
                System.out.println("Invalid value. Please try again: ");
                input.nextLine();
                printMenu();
                choice = input.nextInt();
            }

            switch (choice) {
                case 1:
                    System.out.println("User Id: ");
                    userId = input.nextInt();
                    boolean userDeleted=  userService.deleteUser(userId);
                    if(!userDeleted){
                        menu(input,userService);
                    }
                    userHints(input, userService);
                    break;
                case 2:
                    System.out.println("User Id : ");
                    userId = input.nextInt();
                    System.out.println("Password : ");
                    password = input.nextLine();
                    input.nextLine();
                    System.out.println("Email : ");
                    email = input.nextLine();
                    System.out.println("Address : ");
                    address = input.nextLine();
                    System.out.println("Phone Number : ");
                    phoneNumber = input.nextLine();
                    System.out.println("Salary : ");
                    salary = input.nextDouble();
                    userService.updateUser(userId, password, email, address, phoneNumber, salary);
                    break;

                case 3:
                    System.out.println("User Id: ");
                    userId= input.nextInt();
                    userService.listAllUser(userId);
                    break;
                case 4:
                    System.out.println("User Id : ");
                    userId = input.nextInt();
                    System.out.println("Account type : ");
                    String accountType = input.nextLine();
                    accountService.createAccount(userId, accountType);
                    break;
                case 5:
                    accountService.listAllAccounts();
                    break;
                case 6:
                    System.out.println("Account Number : ");
                    accountNumber = input.nextLong();
                    accountService.checkBalanceFunctionality(accountNumber);
                    break;
                case 7:
                    System.out.println("Account Number : ");
                    accountNumber = input.nextLong();
                    accountService.confirmBeforeDeletingAccount(accountNumber);
                    break;
                case 8:
                    System.out.println("Amount : ");
                    amount = input.nextFloat();
                    System.out.println("Account Number ");
                    accountNumber = input.nextLong();
                    accountService.withDrawMoney(amount, accountNumber);
                    break;
                case 9:
                    System.out.println("Amount : ");
                    amount = input.nextFloat();
                    System.out.println("Account Number :");
                    accountNumber = input.nextLong();
                    accountService.depositMoney(amount, accountNumber);
                    break;
                case 10:
                    System.out.println("User Id :");
                    userId = input.nextInt();
                    System.out.println("Loan : ");
                    float loan = input.nextFloat();
                    System.out.println("Month  : ");
                    int month = input.nextInt();
                    accountService.loanManagement(userId, loan, month);
                    break;
                case 11:
                    System.out.println("User Id : ");
                    userId = input.nextInt();
                    System.out.println("Installments : ");
                    int installments = input.nextInt();
                    accountService.creditPayment(userId, installments);
                    break;
                case 12:
                    accountService.accountHistoryList();
                    break;

                case 13:
                    System.out.println("User Id : ");
                    userId=input.nextInt();
                    accountService.creditInformation(userId);
                    break;

                case 14:
                    System.out.println("Logging out of the banking system...");
                    System.exit(0);
                    break;

            }
        } while (choice != 1);
    }

}
