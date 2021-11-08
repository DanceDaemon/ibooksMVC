package com.example.ibooksproject.models.book;

import com.example.ibooksproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BookDAO {
    public List<Book> findAll();
    public Book findById(int id);
}
