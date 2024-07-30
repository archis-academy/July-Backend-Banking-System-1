package org.example.user;

import org.example.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

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