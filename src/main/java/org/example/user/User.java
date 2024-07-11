package org.example.user;

public class User {
    public int userId;
    public String fullName;
    public String password;
    public String email;
    public int age;
    public String address;
    public String phoneNumber;
    public int itentityNumber;


    public User(int userId, String fullName, String password, String email, int age, String address, String phoneNumber, int itentityNumber) {
        this.userId = userId;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.itentityNumber = itentityNumber;
    }
}
