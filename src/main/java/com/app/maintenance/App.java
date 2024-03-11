package com.app.maintenance;

import com.app.maintenance.model.Role;
import com.app.maintenance.model.User;
import com.app.maintenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class App {
    private static final Scanner sc = new Scanner(System.in);

//    @Autowired
    private final UserService userService;

    @Autowired
    public App(UserService userService) {
        this.userService = userService;
    }

    public void startCommandLineLoop () {
        String mainMenuChoice;
        do {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1: Manage Users");
            System.out.println("2: Manage Items");
            System.out.println("3: Exit");
            System.out.println("Enter option: ");
            mainMenuChoice = sc.nextLine();

            switch (mainMenuChoice) {
                case "1":
                    manageUsers();
                    break;
                case "2":
                    System.out.println("Item mgmt isn't implemented yet");
                    break;
                case "3":
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid option, please try again");
            }
        } while (!mainMenuChoice.equals("3"));
    }
//    private static void manageUsers() {
    private void manageUsers() {
//        UserService userService = new UserService();
        String userChoice;
        do {
            System.out.println("\n--- Manage Users ---");
            System.out.println("1: Add User");
            System.out.println("2: View Users");
            System.out.println("3: Update User");
            System.out.println("4: Delete User");
            System.out.println("5: Return to Main Menu");
            System.out.println("Enter option: ");
            userChoice = sc.nextLine();

            switch (userChoice) {
                case "1":
//                    System.out.println("Add user not implemented yet");
                    addUser(userService);
                    break;
                case "2":
//                    System.out.println("View users not implemented yet");
                    viewUser(userService);
                    break;
                case "3":
                    updateUser(userService);
//                    System.out.println("Update user not implemented yet");
                    break;
                case "4":
                    deleteUser(userService);
//                    System.out.println("Delete user not implemented yet");
                    break;
                case "5":
                    System.out.println("Returning to Main Menu");
                    break;
                default:
                    System.out.println("Invalid option, please try again");
            }
        } while (!userChoice.equals("5"));
    }

//    private static void addUser(UserService userService) {
    private void addUser(UserService userService) {
        System.out.println("Enter user details: ");
        System.out.println("Name: ");
        String name = sc.nextLine();

        System.out.println("Contact Info: ");
        String contactInfo = sc.nextLine();

        System.out.println("Login credentials: ");
        String loginCredentials = sc.nextLine();

        int roleSelection;
        Role selectedRole = null;
//        String selectedRole = null;
        do {
            System.out.println("Select Role: 1 for ADMIN, 2 for USER, 3 for TESTER");
            try {
                roleSelection = Integer.parseInt(sc.nextLine());
                switch (roleSelection) {
                    case 1:
                        selectedRole = Role.admin;
//                        selectedRole = Role.ADMIN;
//                        selectedRole = "ADMIN";
                        break;
                    case 2:
                        selectedRole = Role.user;
//                        selectedRole = Role.USER;
//                        selectedRole = "USER";
                        break;
                    case 3:
                        selectedRole = Role.tester;
//                        selectedRole = Role.TESTER;
//                        selectedRole = "TESTER";
                        break;
                    default:
                        System.out.println("Invalid selection, please choose 1, 2 or 3");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
                roleSelection = 0; // Reset to prompt again
                System.out.println(e.getMessage());
            }
        } while (selectedRole == null);
//        System.out.println("Role: ADMIN / USER / TESTER: ");
//        String role = sc.nextLine();

        User user = new User();
        user.setName(name);
        user.setContactInfo(contactInfo);
        user.setLoginCredentials(loginCredentials);
//        user.setRole(Role.valueOf(role.toUpperCase()));
        user.setRole(selectedRole);

        try {
            userService.saveUser(user);
            System.out.println("User added successfully");
        } catch (Exception e) {
            System.out.println("Failed to add user: " + e.getMessage());
        }
    }

    private static void viewUser(UserService userService) {
        System.out.println("\nList of Users: ");
        List<User> users = userService.getAllUsers();

        if (users.isEmpty()) {
            System.out.println("No users found");
        } else {
            for (User user: users) {
                String roleUpperCase = user.getRole().toString().toUpperCase();
//                System.out.println("ID: " + user.getUserId() + ", Name: " + user.getName() + ", Role: " + user.getRole());
                System.out.println("ID: " + user.getUserId() + ", Name: " + user.getName() + ", Role: " + roleUpperCase);
            }
        }
    }

    private static void updateUser(UserService userService) {
        System.out.println("Enter the ID of the user you want to update: ");
        String id = sc.nextLine();

        Optional<User> optionalUser = userService.getUser(Long.parseLong(id));

        if (optionalUser.isEmpty()) {
            System.out.println("User not found");
            return;
        }

        User user = optionalUser.get();

        System.out.println("Updating user: " + user.getName() + ". Enter new details: ");

        System.out.print("Name (" + user.getName() + "): ");
        String name = sc.nextLine();
        if (!name.isEmpty()) {
            user.setName(name);
        }

        System.out.print("Contact Info (" + user.getContactInfo() + "): ");
        String contactInfo = sc.nextLine();
        if (!contactInfo.isEmpty()) {
            user.setContactInfo(contactInfo);
        }

        int roleSelection;
        Role selectedRole = null;
//        String selectedRole = null;
        do {
            System.out.println("Select Role: 1 for ADMIN, 2 for USER, 3 for TESTER");
            try {
                roleSelection = Integer.parseInt(sc.nextLine());
                switch (roleSelection) {
                    case 1:
                        selectedRole = Role.admin;
//                        selectedRole = Role.ADMIN;
//                        selectedRole = "ADMIN";
                        break;
                    case 2:
                        selectedRole = Role.user;
//                        selectedRole = Role.USER;
//                        selectedRole = "USER";
                        break;
                    case 3:
                        selectedRole = Role.tester;
//                        selectedRole = Role.TESTER;
//                        selectedRole = "TESTER";
                        break;
                    default:
                        System.out.println("Invalid selection, please choose 1, 2 or 3");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
                roleSelection = 0; // Reset to prompt again
                System.out.println(e.getMessage());
            }
        } while (selectedRole == null);

//        System.out.print("Role (" + user.getRole() + "): ");
//        String role = sc.nextLine();
//        if (!role.isEmpty()) {
//            user.setRole(Role.valueOf(role.toUpperCase()));
//        }
        user.setRole(selectedRole);

        try {
            userService.updateUser(user);
            System.out.println("User successfully updated");
        } catch(Exception e) {
            System.out.println("Failed ot update user: " + e.getMessage());
        }
    }

    private static void deleteUser(UserService userService) {
        System.out.println("Enter the ID of the user you want to delete: ");
        String idStr = sc.nextLine();
        long id;
        try {
            id = Long.parseLong(idStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format");
            return;
        }

        System.out.println("Are you sure you want to delete this user?");
        String confirmation = sc.nextLine();
        if (!"yes".equalsIgnoreCase(confirmation)) {
            System.out.println("User deletion cancelled");
            return;
        }

        try {
            userService.deleteUser(id);
            System.out.println("User successfully deleted");
        } catch (Exception e) {
            System.out.println("Falied to delete user: " + e.getMessage());
        }
    }
}


