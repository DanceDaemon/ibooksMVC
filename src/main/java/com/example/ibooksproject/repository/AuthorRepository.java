package com.example.ibooksproject.repository;

import com.example.ibooksproject.models.authors.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
