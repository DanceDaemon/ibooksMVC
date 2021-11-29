package com.example.ibooksproject.service.book;

import com.example.ibooksproject.models.book.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public List<Book> findAll();
    public Book findById(int id);
    public boolean updateLikes(int user_id, int book_id);
    public boolean updateDislikes(int user_id, int book_id);
}
