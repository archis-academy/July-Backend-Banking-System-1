package org.example.user;

<<<<<<< Updated upstream
import java.util.ArrayList;
=======
public class UserService{
>>>>>>> Stashed changes



<<<<<<< Updated upstream
    }

    ArrayList<User> userList = new ArrayList<>();

    public User getUserById(int userId) {
        boolean isFound = false;
        for (User user : userList) {
            if (user.userId == userId) {
                isFound = true;
                System.out.println("User found successfully!");
                return user;
            }
            break;
        }
        if (!isFound) {
            System.out.println("User couldn't found!");
        }
        return null;
    }
=======
>>>>>>> Stashed changes
}


