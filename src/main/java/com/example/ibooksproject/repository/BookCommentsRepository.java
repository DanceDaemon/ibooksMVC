package com.example.ibooksproject.repository;

import com.example.ibooksproject.models.comments.BookComments;
import com.example.ibooksproject.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookCommentsRepository extends JpaRepository<BookComments, Integer> {

}
