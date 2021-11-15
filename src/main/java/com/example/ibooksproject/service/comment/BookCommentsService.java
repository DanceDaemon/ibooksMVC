package com.example.ibooksproject.service.comment;

import com.example.ibooksproject.models.comments.BookComments;
import org.springframework.stereotype.Service;

@Service
public interface BookCommentsService {
    public boolean saveComment(BookComments bookComments);
}
