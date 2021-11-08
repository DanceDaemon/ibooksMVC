package com.example.ibooksproject.controllers;

import com.example.ibooksproject.models.user.User;
import com.example.ibooksproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/sign_up")
    public String signUp(Model model) {
        model.addAttribute("userForm", new User());

        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String addUser(@ModelAttribute("userForm") User userForm, Model model) {
        userService.createUser(userForm);
        return "redirect:/";
    }

}
