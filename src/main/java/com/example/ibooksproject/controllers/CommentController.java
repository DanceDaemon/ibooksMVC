package com.example.ibooksproject.controllers;

import com.example.ibooksproject.models.comments.BookComments;
import com.example.ibooksproject.repository.BookCommentsRepository;
import com.example.ibooksproject.service.book.BookService;
import com.example.ibooksproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookCommentsRepository repository;

    @PostMapping(value = "/addcomment")
    public String addComment(int bookId, BookComments bookComments, int userId) {
        System.out.println(bookId);
        System.out.println(userId);
        bookComments.setBook(bookService.findById(bookId));
        bookComments.setUser(userService.getUserById(userId));
        repository.save(bookComments);

        return "main_page";
    }
}
