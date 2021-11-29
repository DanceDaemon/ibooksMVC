package com.example.ibooksproject.models.book;

import com.example.ibooksproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAOImpl implements BookDAO {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.getById(id);
    }

    @Override
    public boolean addLike(int user_id, int book_id) {
        bookRepository.addLike(user_id, book_id);
        return true;
    }

    @Override
    public boolean deleteLike(int user_id, int book_id) {
        bookRepository.deleteLike(user_id, book_id);
        return true;
    }

    @Override
    public boolean addDislike(int user_id, int book_id) {
        bookRepository.addDislike(user_id, book_id);
        return true;
    }

    @Override
    public boolean deleteDislike(int user_id, int book_id) {
        bookRepository.deleteDislike(user_id, book_id);
        return true;
    }
}
