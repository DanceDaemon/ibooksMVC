package com.example.ibooksproject.controllers;


import com.example.ibooksproject.models.book.Book;
import com.example.ibooksproject.models.comments.BookComments;
import com.example.ibooksproject.models.user.User;
import com.example.ibooksproject.repository.BookRepository;
import com.example.ibooksproject.repository.UserRepository;
import com.example.ibooksproject.service.book.BookService;
import com.example.ibooksproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Set;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "booksTemplates/books_list";
    }

    @GetMapping(value = "/book", params = {"id"})
    public String getBookById(@RequestParam(value = "id") int id, Model model,  Authentication authentication) {
        model.addAttribute("book", bookService.findById(id));
        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userService.getUserByLogin(userDetails.getUsername());
            model.addAttribute("currentUser", user);
            model.addAttribute("comment", new BookComments());
        }

        return "booksTemplates/book";
    }

    @GetMapping(value = "/like/book", params = {"id"})
    public RedirectView likeBook(@RequestParam(value = "id") int id, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.getUserByLogin(userDetails.getUsername());
        Book book = bookService.findById(id);

        bookService.updateLikes(user.getId(), book.getId());

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/book?id=" + book.getId());

        return redirectView;
    }

    @GetMapping(value = "/dislike/book", params = {"id"})
    public RedirectView dislikeBook(@RequestParam(value = "id") int id, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.getUserByLogin(userDetails.getUsername());
        Book book = bookService.findById(id);

        bookService.updateDislikes(user.getId(), book.getId());

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/book?id=" + book.getId());

        return redirectView;
    }

}
