package org.example.user;


import org.example.user.User;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;



public class UserService {
    ArrayList<User> userList = new ArrayList<>();


    List<User> userList;

    public UserService() {
        this.userList = new ArrayList<>();
    }

    public User getUserById(String id) {
        for (User user : userList) {
            if (user.identityNumber.equals(id)) {
                return user;
            }
        }
        System.out.println("User not found. ");
        return null;
    }



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



