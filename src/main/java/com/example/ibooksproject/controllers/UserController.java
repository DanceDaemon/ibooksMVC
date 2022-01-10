package com.example.ibooksproject.controllers;

import com.example.ibooksproject.models.user.User;
import com.example.ibooksproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model, Authentication authentication) {
        if (authentication != null) model.addAttribute("isAuth", true);
        else model.addAttribute("isAuth", false);
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", new User());

        return "register";
    }

    @PostMapping("/register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userService.createUser(user);

        return "redirect:login";
    }

    @GetMapping("/login")
    public String logAndReg(Model model) {
        model.addAttribute("userForm", new User());

        return "/log_reg/login";
    }

    @GetMapping("/user")
    public String userProfile(Model model, @RequestParam(value = "id") int id, Authentication authentication) {
        if (authentication != null) model.addAttribute("isAuth", true);
        else model.addAttribute("isAuth", false);
        model.addAttribute("user", userService.getUserById(id));

        return "user";
    }

}
