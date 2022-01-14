package com.example.ibooksproject.controllers;

import com.example.ibooksproject.models.comments.BookComments;
import com.example.ibooksproject.repository.BookCommentsRepository;
import com.example.ibooksproject.service.book.BookService;
import com.example.ibooksproject.service.comment.BookCommentsService;
import com.example.ibooksproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CommentController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private BookCommentsService bookCommentsService;

    @PostMapping(value = "/addcomment")
    public RedirectView addComment(int bookId, BookComments bookComments, int userId) {
        System.out.println(bookId);
        System.out.println(userId);
        bookComments.setBook(bookService.findById(bookId));
        bookComments.setUser(userService.getUserById(userId));
        bookCommentsService.saveComment(bookComments);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("https://ibooks-heroku.herokuapp.com/book?id=" + bookId);

        return redirectView;

    }
}
