package com.example.ibooksproject.models.comments;

import com.example.ibooksproject.repository.BookCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public interface BookCommentsDAO {
    public boolean saveComment(BookComments bookComments);
}
