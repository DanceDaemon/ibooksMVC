package com.example.ibooksproject.service;

import com.example.ibooksproject.models.book.Book;
import com.example.ibooksproject.models.book.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public Book findById(int id) {
        return bookDAO.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }
}
