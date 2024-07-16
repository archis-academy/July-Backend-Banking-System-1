package org.example.user;

import java.util.List;

public class UserService {
    final List<User> userList;

    public UserService(List<User> userList) {
        this.userList = userList;
    }

    public User getUserById(int userId) {
        for (User user : userList) {
            if (user.userId == userId) {
                System.out.println("User could found succesfully:");
                return user;
            }
        }
            System.out.println("User couldn't found!");
        return null;
    }
}
