package org.example.user;

import org.example.account.Account;

public class User {
    public String userId;
    public String fullName;
    public String password;
    public String email;
    public int age;
    public String address;
    public String phoneNumber;
    public String identityNumber;
    public Account account;
    public double salary;
    public double creditScore = 0.0;
    public double totalDebt;
    public int installments;


    public User() {

    }

    public User(String userId, String fullName, String password, String email, int age, String address,
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
