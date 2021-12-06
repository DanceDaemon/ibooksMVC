package com.example.ibooksproject.controllers;

import com.example.ibooksproject.service.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GenresController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public String getAllGenres(Model model, Authentication authentication) {
        if (authentication != null) model.addAttribute("isAuth", true);
        else model.addAttribute("isAuth", false);
        model.addAttribute("genres", genreService.findAll());
        return "genres";
    }

    @GetMapping(value = "/genre", params = {"id"})
    public String getAuthorPage(@RequestParam(value = "id") int id, Model model, Authentication authentication) {
        if (authentication != null) model.addAttribute("isAuth", true);
        else model.addAttribute("isAuth", false);
        model.addAttribute("genre", genreService.findById(id));
        //System.out.println(genreService.findById(id).getName());
        return "genre";
    }
}
