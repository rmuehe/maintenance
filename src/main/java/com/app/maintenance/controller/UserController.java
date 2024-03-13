package com.app.maintenance.controller;

import com.app.maintenance.model.Role;
import com.app.maintenance.model.User;
import com.app.maintenance.service.UserService;
import com.app.maintenance.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserServiceInterface userService;

    public  UserController(UserService userService) {
        this.userService = userService;
    }

    // Handler method to display the user list
    @GetMapping("/user-management")
    public String showUserListAndForm(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("userForm",  new User()); // For adding a new user
        return "user-management";
    }

    // Handler method for adding a new user
    @PostMapping("/add")
    public String addUser(@ModelAttribute("userForm") User user) {
        userService.saveUser(user);
        return "redirect:/users/user-management";
    }

    // Handler method to display the user form for updating an existing user
    @GetMapping("/edit/{userId}")
    public String showEditUserForm(@PathVariable Long userId, Model model) {
        User user = userService.getUser(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + userId));
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", user);
        return "user-management";
    }

    // Handler method to process the form submission for updating an existing user
    @PostMapping("/edit/")
    public String updateUser(@ModelAttribute("userForm") User user) {
        userService.saveUser(user); // save will update if already exists
        return "redirect:/users/user-management";
    }

    @GetMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return "redirect:/users/user-management";
    }
}
