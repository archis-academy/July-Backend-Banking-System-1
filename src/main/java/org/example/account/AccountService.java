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

    public AccountService(UserService userService) {
        this.userService = userService;
        this.accountList = new ArrayList<>();


    }


    public long generateAccountNumber() {
        long accountNumber;
        Random random = new Random();
        accountNumber = 10000000 + random.nextLong(89999999);
        return accountNumber;
    }


    public Account getAccountByAccountNumber(int accountNumber) {
        for (Account account : accountList) {
            if (account.AccountNumber == accountNumber) {
                return account;
            }
        }
        System.out.println("Account couldn't found!");
        return null;
    }


    public List<Account> listAllAccounts() {
        boolean accountsQuantity = accountList.isEmpty();
        if (accountsQuantity != false) {
            return accountList;
        }
        System.out.println("There is no account!");
        return null;
    }


    public String deleteAccount(int accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            accountList.remove(account);
            return "Delete transaction successfully:";
        } else {
            return "Not found account number!";
        }
    }


    public Float checkBalanceFunctionality(int accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            return account.AccountBalance;
        } else {
            return null;
        }
    }

    public double calculateMonthlyPayment(double loan, int month) {
        double totalPayment = loan + (loan * interestRate);
        double montlyPayment =  totalPayment /  month;
        return montlyPayment;
    }

    public Double loanManagement(String userId, float loan, int month) {
        User user = userService.getUserById(userId);
        double takeMaxLoan = user.salary * 30;
        if (user != null && loan <= takeMaxLoan) {
            AccountHistory accountHistory=new AccountHistory();
            user.account.AccountBalance += loan;
            user.totalDebt = loan + (loan * interestRate);
            accountHistory.isSuccess=true;
            accountHistory.amount=loan;
            accountHistory.date= LocalDate.now();
            user.account.accountHistory.add(accountHistory);
            return calculateMonthlyPayment(loan, month);
        }
        throw new RuntimeException("User not found with this Id number!");
    }

    public String creditPayment(String userId, int installments) {
        User user = userService.getUserById(userId);
        double monthlyPayment=(user.totalDebt)/user.installments;
        double deductedAmount=monthlyPayment*installments;
        if (user != null && user.totalDebt >= deductedAmount) {
            AccountHistory accountHistory=new AccountHistory();
            user.account.AccountBalance -= (float) deductedAmount;
            user.installments-=installments;
            creditScore(userId,1);
            accountHistory.isSuccess=true;
            accountHistory.date=LocalDate.now();
            user.account.accountHistory.add(accountHistory);
            return "Approve : Payment successful." ;
        } else {
            return "Reject: Insufficient balance or user not found.";
        }

    }

    public void creditScore(String userId, int paymentsMade) {
        User user = userService.getUserById(userId);
        if (user != null) {
            user.creditScore += paymentsMade;
        } else {
            throw new RuntimeException("User not found with this Id Number");
        }
    }


}

