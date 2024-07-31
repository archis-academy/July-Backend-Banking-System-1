package org.example.user;

import java.util.ArrayList;
import java.util.Random;


public class UserService {
    ArrayList<User> userList = new ArrayList<>();
    public long userQuantity = 0;


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

        public int generateUserId() {
        int userId;
        Random random = new Random();
        userId = 10000 + random.nextInt(8999);
        return userId;
        }

        public User createUser(){
            User user = new User();
            user.userId = generateUserId();
            userList.add(user);
            userQuantity ++;
            return user;
        }

        public String deleteUser(int userId) {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).userId == userId) {
                    userList.remove(i);
                    return "User deleted successfully!";
                }
            }
            return "User couldn't found with that id!";
        }

        public String updateUser(int userId, String changingValue, String newValue) {
            for (User user : userList) {
                if (user.userId == userId) {
                    switch (changingValue.toLowerCase()) {
                        case "fullname":
                            user.fullName = newValue;
                            break;
                        case "password":
                            user.password = newValue;
                            break;
                        case "email":
                            user.email = newValue;
                            break;
                        case "age":
                            user.age = Integer.parseInt(newValue);
                            break;
                        case "address":
                            user.address = newValue;
                            break;
                        case "phonenumber":
                            user.phoneNumber = newValue;
                            break;
                        case "identitynumber":
                            user.identityNumber = Integer.parseInt(newValue);
                            break;
                        default:
                            return "Invalid field name!";
                    }
                    return "User updated successfully!";
                }
            }
            return "User couldn't found with that id!";
        }
    }


