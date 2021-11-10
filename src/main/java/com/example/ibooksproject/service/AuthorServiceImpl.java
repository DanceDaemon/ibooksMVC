package com.example.ibooksproject.service;

import com.example.ibooksproject.models.authors.Author;
import com.example.ibooksproject.models.authors.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }

    @Override
    public Author findById(int id) {
        return authorDAO.findById(id);
    }
}
