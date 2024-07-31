package org.example.account;


import org.example.user.User;
import org.example.user.UserService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AccountService {
    List<Account> accountList;
    double interestRate = 0.25;
    private final UserService userService;
    public long accountQuantity = 0;

    public AccountService(UserService userService) {
        this.userService = userService;
        this.accountList = new ArrayList<>();

    }


    public Account createAccount(int userId, String accountType) {
        User user = userService.getUserById(userId);
        if (user != null) {
            throw new RuntimeException("User not found with this Id number!");
        }
        user.creditScore = 1.0;
        Account account = new Account();
        account.accountNumber = generateAccountNumber();
        account.accountId = accountQuantity + 1;
        account.accountHolder = user.fullName;
        account.accountType = accountType;
        account.accountBalance = 0.0f;
        account.CreatedDate = LocalDate.now();
        accountList.add(account);
        accountQuantity++;
        return account;

    }


    public long generateAccountNumber() {
        long accountNumber;
        Random random = new Random();
        accountNumber = 1_000_000_000_000_000L + random.nextLong(8_999_999_999_999_999L);
        return accountNumber;
    }


    public Account getAccountByAccountNumber(long accountNumber) {
        for (Account account : accountList) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }
        System.out.println("Account couldn't found!");
        return null;
    }


    public List<Account> listAllAccounts() {
        boolean accountsQuantity = accountList.isEmpty();
        if (accountsQuantity) {
            return accountList;
        }
        System.out.println("There is no account!");
        return null;
    }



    public Float checkBalanceFunctionality(long accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            return account.accountBalance;
        } else {
            return null;

        }
    }

    public String withDrawMoney(float amount, long accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null && account.accountBalance >= amount && isPositiveInput(amount)) {
            AccountHistory accountHistory = new AccountHistory();
            account.accountBalance -= amount;
            accountHistory.amount = amount;
            accountHistory.isSuccess = true;
            account.accountHistory.add(accountHistory);
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
            account.accountHistory.add(accountHistory);
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
            user.totalDebt = loan + (loan * interestRate);
            accountHistory.isSuccess = true;
            accountHistory.amount = loan;
            accountHistory.date = LocalDate.now();
            user.account.accountHistory.add(accountHistory);
            return calculateMonthlyPayment(loan, month);
        }
        throw new RuntimeException("User not found with this Id number!");
    }

    public String creditPayment(int userId, int installments) {
        User user = userService.getUserById(userId);
        double monthlyPayment = (user.totalDebt) / user.installments;
        double deductedAmount = monthlyPayment * installments;
        if (user != null && user.totalDebt >= deductedAmount) {
            AccountHistory accountHistory = new AccountHistory();
            user.account.accountBalance -= (float) deductedAmount;
            user.installments -= installments;
            user.creditScore += installments;
            accountHistory.isSuccess = true;
            accountHistory.date = LocalDate.now();
            user.account.accountHistory.add(accountHistory);
            return "Approve : Payment successful.";
        } else {
            return "Reject: Insufficient balance or user not found.";
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


}




