package com.example.ibooksproject.repository;

import com.example.ibooksproject.models.genres.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
