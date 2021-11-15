package com.example.ibooksproject.service.comment;

import com.example.ibooksproject.models.comments.BookComments;
import com.example.ibooksproject.models.comments.BookCommentsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCommentsServiceImpl implements BookCommentsService {

    @Autowired
    private BookCommentsDAO bookCommentsDAO;

    @Override
    public boolean saveComment(BookComments bookComments) {
        bookCommentsDAO.saveComment(bookComments);
        return true;
    }
}
