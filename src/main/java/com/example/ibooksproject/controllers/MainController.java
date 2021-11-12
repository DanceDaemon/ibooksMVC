package com.example.ibooksproject.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(Model model, Authentication authentication) {
        if (authentication != null) {
            model.addAttribute("currentUser", (UserDetails) authentication.getPrincipal());
            System.out.println((UserDetails) authentication.getPrincipal());
        }

        return "main_page";
    }


}
