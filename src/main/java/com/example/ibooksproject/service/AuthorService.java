package com.example.ibooksproject.service;

import com.example.ibooksproject.models.authors.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public List<Author> findAll();
}
