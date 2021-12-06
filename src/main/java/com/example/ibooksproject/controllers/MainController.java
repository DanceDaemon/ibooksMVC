package com.example.ibooksproject.controllers;

import com.example.ibooksproject.models.user.User;
import com.example.ibooksproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public RedirectView mainPageAuthorized(Model model, Authentication authentication) {
        if (authentication != null) {

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userService.getUserByLogin(userDetails.getUsername());

            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("http://localhost:8080/user?id=" + user.getId());
            return redirectView;
        }

        return new RedirectView("http://localhost:8080/main_page");
    }

    @GetMapping("main_page")
    public String mainPageNonAuthorized(Model model, Authentication authentication) {
        if (authentication != null) model.addAttribute("isAuth", true);
        else model.addAttribute("isAuth", false);
        return "main_page";
    }


}
