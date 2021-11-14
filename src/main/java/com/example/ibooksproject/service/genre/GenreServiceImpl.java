package com.example.ibooksproject.service.genre;

import com.example.ibooksproject.models.genres.Genre;
import com.example.ibooksproject.models.genres.GenreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDAO genreDAO;

    @Override
    public List<Genre> findAll() {
        return genreDAO.findAll();
    }

    @Override
    public Genre findById(int id) {
        return genreDAO.findById(id);
    }
}
