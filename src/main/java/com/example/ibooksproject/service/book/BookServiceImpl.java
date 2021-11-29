package com.example.ibooksproject.service.book;

import com.example.ibooksproject.models.book.Book;
import com.example.ibooksproject.models.book.BookDAO;
import com.example.ibooksproject.models.user.UserDAO;
import com.example.ibooksproject.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public Book findById(int id) {
        return bookDAO.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public boolean updateLikes(int user_id, int book_id) {
        if (!bookDAO.findById(book_id).getLikes().contains(userService.getUserById(user_id))) {
            return bookDAO.addLike(user_id, book_id);
        }
        return bookDAO.deleteLike(user_id, book_id);
    }

    @Override
    public boolean updateDislikes(int user_id, int book_id) {
        if (!bookDAO.findById(book_id).getDislikes().contains(userService.getUserById(user_id))) {
            return bookDAO.addDislike(user_id, book_id);
        }
        return bookDAO.deleteDislike(user_id, book_id);
    }
}
