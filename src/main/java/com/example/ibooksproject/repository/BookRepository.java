package com.example.ibooksproject.repository;

import com.example.ibooksproject.models.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}

