package com.example.ibooksproject.models.book;

import com.example.ibooksproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BookDAO {
    public List<Book> findAll();
    public Book findById(int id);
    public boolean addLike(int user_id, int book_id);
    public boolean deleteLike(int user_id, int book_id);
    public boolean addDislike(int user_id, int book_id);
    public boolean deleteDislike(int user_id, int book_id);
}
