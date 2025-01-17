package org.example.user;

import org.example.account.Account;
import org.example.account.SavingAccount;

public class User {
    public int userId;
    public String fullName;
    public String password;
    public String email;
    public int age;
    public String address;
    public String phoneNumber;
    public String identityNumber;
    public Account account;
    public SavingAccount savingAccount;
    public double salary;
    public double creditScore = 0.0;
    public double totalDebt;
    public int installments;


    public User() {

    }

    public User(int userId, String fullName, String password, String email, int age, String address,
                String phoneNumber, String identityNumber, double salary, double creditScore,double totalDebt) {
        this.userId = userId;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.identityNumber = identityNumber;
        this.salary = salary;
        this.creditScore = creditScore;
        this.totalDebt=totalDebt;
    }


}
