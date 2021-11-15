package com.example.ibooksproject.models.comments;

import com.example.ibooksproject.repository.BookCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BookCommentsDAOImpl implements BookCommentsDAO {
    @Autowired
    private BookCommentsRepository bookCommentsRepository;

    @Override
    public boolean saveComment(BookComments bookComments) {
        bookCommentsRepository.save(bookComments);
        return true;
    }
}
