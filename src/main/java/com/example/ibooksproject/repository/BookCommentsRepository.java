package com.example.ibooksproject.repository;

import com.example.ibooksproject.models.comments.BookComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCommentsRepository extends JpaRepository<BookComments, Integer> {
}
