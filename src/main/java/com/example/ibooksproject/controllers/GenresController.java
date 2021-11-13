package com.example.ibooksproject.controllers;

import com.example.ibooksproject.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GenresController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public String getAllGenres(Model model) {
        model.addAttribute("genres", genreService.findAll());
        return "genres";
    }

    @GetMapping(value = "/genre", params = {"id"})
    public String getAuthorPage(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("genre", genreService.findById(id));
        //System.out.println(genreService.findById(id).getName());
        return "genre";
    }
}
