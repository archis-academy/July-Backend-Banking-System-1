package org.example.account;


import org.example.user.User;
import org.example.user.UserService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class AccountService {
    public static final String USER_NOT_FOUND_WITH_THIS_ID_NUMBER = "User not found with this Id number!";
    public static final String ACCOUNT_COULDN_T_FOUND = "Account couldn't found!";
    public static final String ACCOUNT_DELETED_SUCCESSFULLY = "Account deleted successfully";
    public static final String ACCOUNT_CREATED_SUCCESSFULLY = "Account created successfully.";
    List<Account> accountList;
    List<AccountHistory> accountHistoryList;
    double interestRate = 0.25;

    private final UserService userService;
    public long accountQuantity = 0;

    public AccountService(UserService userService) {
        this.userService = userService;
        this.accountList = new ArrayList<>();
        this.accountHistoryList = new ArrayList<>();

    }


    public Account createAccount(int userId, String accountType) {
        User user = userService.getUserById(userId);
        if (user != null) {
            user.creditScore = 1.0;
            Account account = new Account();
            account.accountNumber = generateAccountNumber();
            account.accountId = accountQuantity + 1;
            account.accountHolder = user.fullName;
            account.accountType = accountType;
            account.accountBalance = 0.0f;
            account.CreatedDate = LocalDate.now();
            user.account = account;
            accountList.add(account);
            accountQuantity++;
            return account;
        }
        throw new RuntimeException(ACCOUNT_CREATED_SUCCESSFULLY);
    }


    public long generateAccountNumber() {
        long accountNumber;
        Random random = new Random();
        accountNumber = 1000000000000000L + random.nextLong(8999999999999999L);
        return accountNumber;
    }


    public Account getAccountByAccountNumber(long accountNumber) {
        for (Account account : accountList) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }
        System.out.println(ACCOUNT_COULDN_T_FOUND);
        return null;
    }


    public List<Account> listAllAccounts() {
        boolean accountsQuantity = accountList.isEmpty();
        if (!accountsQuantity) {
            printAccountList();
            return accountList;
        }
        System.out.println(ACCOUNT_COULDN_T_FOUND);
        return null;
    }


    public Float checkBalanceFunctionality(long accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            System.out.println("Account Balance : " + account.accountBalance);
            return account.accountBalance;
        } else {
            return null;

        }
    }

    public void printAccountList() {
        for (Account account : accountList) {
            System.out.println("Account ID: " + account.accountId + ",Account Number: " + account.accountNumber +
                    ", Account Type  " + account.accountType + ", Account Balance: " + account.accountBalance + ", Account Holder: " + account.accountHolder +
                    ", Date: " + account.CreatedDate);
        }
    }

    public static boolean isPositiveInput(Object input) {
        if (input instanceof Integer) {
            return ((Integer) input) > 0;
        }
        if (input instanceof Long) {
            return ((Long) input) > 0;
        }
        if (input instanceof Float) {
            return ((Float) input) > 0;
        }
        if (input instanceof Double) {
            return ((Double) input) > 0;
        } else {
            return false;
        }
    }

    public void deleteAccount(long accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            accountList.remove(account);
        }
    }

    public String confirmBeforeDeletingAccount(long accountNumber) {
        Scanner scan = new Scanner(System.in);
        System.out.println("yes/no");
        String userInput = scan.nextLine();
        boolean confirm = userInput.equalsIgnoreCase(userInput);
        if (confirm) {
            deleteAccount(accountNumber);
            return ACCOUNT_DELETED_SUCCESSFULLY;
        } else {
            return "Deleted canceled";
        }
    }

    public String withDrawMoney(float amount, long accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null && account.accountBalance >= amount && isPositiveInput(amount)) {
            AccountHistory accountHistory = new AccountHistory();
            account.accountBalance -= amount;
            accountHistory.amount = amount;
            accountHistory.isSuccess = true;
            accountHistory.date = LocalDate.now();
            accountHistory.transactionType = "Withdraw";
            accountHistory.location = "Online Banking";
            account.accountHistory.add(accountHistory);
            accountHistoryList.add(accountHistory);
            return "Successfully withdraw " + amount;
        }
        return null;
    }

    public String depositMoney(float amount, long accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null && amount > 0 && isPositiveInput(amount)) {
            AccountHistory accountHistory = new AccountHistory();
            account.accountBalance += amount;
            accountHistory.amount = amount;
            accountHistory.isSuccess = true;
            accountHistory.date = LocalDate.now();
            accountHistory.transactionType = "deposit";
            accountHistory.location = "Online Banking";
            account.accountHistory.add(accountHistory);
            accountHistoryList.add(accountHistory);
            return "Successfully deposit " + amount;
        }
        return null;
    }


    public double calculateMonthlyPayment(double loan, int month) {
        double totalPayment = loan + (loan * interestRate);
        double monthlyPayment = totalPayment / month;
        return monthlyPayment;
    }

    public Double loanManagement(int userId, float loan, int month) {
        User user = userService.getUserById(userId);
        double creditScore = user.creditScore;
        double takeMaxLoan = user.salary * 5 * creditScore;
        if (user != null && loan <= takeMaxLoan) {
            AccountHistory accountHistory = new AccountHistory();
            user.account.accountBalance += loan;
            user.installments=month;
            user.totalDebt = loan + (loan * interestRate);
            accountHistory.isSuccess = true;
            accountHistory.amount = loan;
            accountHistory.date = LocalDate.now();
            accountHistory.transactionType = "Take Credit";
            accountHistory.location = "Online Banking";
            user.account.accountHistory.add(accountHistory);
            accountHistoryList.add(accountHistory);
            System.out.println("Mothly Payment : " + calculateMonthlyPayment(loan, month));
            return calculateMonthlyPayment(loan, month);
        }

        throw new RuntimeException(USER_NOT_FOUND_WITH_THIS_ID_NUMBER);
    }

    public String creditPayment(int userId, int installments) {
        User user = userService.getUserById(userId);
        double monthlyPayment = (user.totalDebt) / user.installments;
        double deductedAmount=monthlyPayment*installments;
        if (user != null && user.totalDebt >= deductedAmount) {
            AccountHistory accountHistory = new AccountHistory();
            user.account.accountBalance -= (float) deductedAmount;
            user.installments -= installments;
            user.creditScore += installments;
            user.totalDebt-=deductedAmount;
            accountHistory.amount=(float) deductedAmount;
            accountHistory.isSuccess = true;
            accountHistory.date = LocalDate.now();
            accountHistory.transactionType = "Credit Payment";
            accountHistory.location = "Online Banking";
            user.account.accountHistory.add(accountHistory);
            accountHistoryList.add(accountHistory);
            return "Approve : Payment successful.";
        } else {
            return "Reject: Insufficient balance or user not found.";
        }

    }

    public void accountHistoryList() {
        for (AccountHistory accountHistory : accountHistoryList) {
            System.out.println("Transaction Type: " + accountHistory.transactionType + ", IsSuccess: " + accountHistory.isSuccess + ", Amount: " +
                    accountHistory.amount + ", Date : " + accountHistory.date + ", Location: " + accountHistory.location);
        }
    }

    public void   creditInformation(int userId) {
        User user =userService.getUserById(userId);
        if (user == null) {
            System.out.println(USER_NOT_FOUND_WITH_THIS_ID_NUMBER);
        }

        if (user != null) {
            System.out.println("Total Debt: " + user.totalDebt + ", Remaining Installments: " + user.installments);
        }
    }


}




