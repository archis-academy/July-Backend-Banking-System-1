package org.example.user;


import java.util.ArrayList;
import java.util.List;


public class UserService {


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
        System.out.println("User couldn't found!");
        return null;
    }

}






