package org.example.user;

import java.util.ArrayList;


public class UserService {
    ArrayList<User> userList = new ArrayList<>();


    public static void main(String[] args) {

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


