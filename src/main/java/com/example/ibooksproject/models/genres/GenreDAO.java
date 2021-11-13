package com.example.ibooksproject.models.genres;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GenreDAO {
    public List<Genre> findAll();
}
