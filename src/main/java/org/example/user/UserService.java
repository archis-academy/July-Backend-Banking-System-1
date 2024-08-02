package org.example.user;


import java.util.ArrayList;
import java.util.List;

public class UserService {

    List<User> userList;

    public UserService() {
        this.userList = new ArrayList<>();
    }

    public User getUserByIdentityNumber(String identityNumber) {
        for (User user : userList) {
            if (user.identityNumber.equals(identityNumber)) {
                return user;
            }
        }
        throw new RuntimeException("Error: User not found.");
    }
}
