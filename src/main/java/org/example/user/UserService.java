package org.example.user;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class UserService {
    public static final String USER_NOT_FOUND_WITH_THAT_ID = "User not found with that id!";
    public static final String USER_DELETED_SUCCESSFULLY = "User deleted Successfully.";
    public long userQuantity = 1;
    List<User> userList;

    public UserService() {
        this.userList = new ArrayList<>();
    }


    public User getUserById(int userId) {
        for (User user : userList) {
            if (user.userId == userId) {
                return user;
            }
        }
        System.out.println(USER_NOT_FOUND_WITH_THAT_ID);
        return null;
    }

    public int generateUserId() {
        int userId;
        Random random = new Random();
        userId = 10000 + random.nextInt(8999);
        return userId;
    }

    public User createUser(String fullName, String password, String email, int age, String address, String phoneNumber, String identityNumber, double salary) {
        User user = new User();
        user.userId = generateUserId();
        user.fullName = fullName;
        user.password = password;
        user.email = email;
        user.age = age;
        user.address = address;
        user.phoneNumber = phoneNumber;
        user.identityNumber = identityNumber;
        user.salary = salary;
        userList.add(user);
        userQuantity++;
        return user;
    }

    public boolean deleteUser(int userId) {
        User user = getUserById(userId);
        if (user != null) {
            userList.remove(user);
            return true;
        }
        return false;
    }

    public String updateUser(int userId, String password, String email, String address, String phoneNumber, double salary) {
        User user = getUserById(userId);
        if (user != null) {
            user.password = password;
            user.email = email;
            user.address = address;
            user.phoneNumber = phoneNumber;
            user.salary = salary;
            return "User updated successfully!";
        }

        return USER_NOT_FOUND_WITH_THAT_ID;
    }

    public void listAllUser(int userId) {
        User user = getUserById(userId);
        if (user != null) {
            printUserList(user);
        } else {
            System.out.println(USER_NOT_FOUND_WITH_THAT_ID);
        }
    }

    public User signUp(String fullName, String password, String email, int age, String address, String phoneNumber, String identityNumber, double salary) {
        return createUser(fullName, password, email, age, address, phoneNumber, identityNumber, salary);
    }

    public User logIn(String identityNumber, String password) {
        for (User user : userList) {
            if (user.identityNumber.equals(identityNumber) && user.password.equals(password)) {
                System.out.println("Login successful!");
                System.out.println("User Id : " + user.userId);
                return user;
            }
        }
        System.out.println("Invalid identityNumber or password!");
        return null;
    }

    public static void printUserList(User user) {
        System.out.println("User ID: " + user.userId + ", Full Name: " + user.fullName + ", Email: " +
                user.email + ", Age: " + user.age + ", Address: " + user.address + ", Phone Number: " +
                user.phoneNumber + ", Identity Number: " + user.identityNumber + ", Salary: " + user.salary);
    }
}



