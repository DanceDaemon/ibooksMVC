package com.example.ibooksproject.controllers;

import com.example.ibooksproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String getAuthorList(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authorsTemplates/authors";
    }

    @GetMapping(value = "/authors", params = {"id"})
    public String getAuthorPage(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("author", authorService.findById(id));
        return "authorsTemplates/author";
    }

}
