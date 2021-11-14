package com.example.ibooksproject.controllers;


import com.example.ibooksproject.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "booksTemplates/books_list";
    }

    @GetMapping(value = "/books", params = {"id"})
    public String getBookById(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "booksTemplates/book";
    }

}
