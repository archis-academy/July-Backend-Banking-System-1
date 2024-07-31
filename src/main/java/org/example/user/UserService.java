package org.example.user;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class UserService {
    public static final String USER_NOT_FOUND_WITH_THAT_ID = "User not found with that id!";
    public long userQuantity=0;

    List<User> userList;

    public UserService() {
        this.userList = new ArrayList<>();
    }


    public User getUserById(int userId) {
        for (User user : userList) {
            if (user.userId == userId) {
                System.out.println("User found successfully!");
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

    public User createUser() {
        User user = new User();
        user.userId = generateUserId();
        userList.add(user);
        userQuantity++;
        return user;
    }

    public String deleteUser(int userId) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).userId == userId) {
                userList.remove(i);
                return "User deleted successfully!";
            }
        }
        return USER_NOT_FOUND_WITH_THAT_ID;
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

}






