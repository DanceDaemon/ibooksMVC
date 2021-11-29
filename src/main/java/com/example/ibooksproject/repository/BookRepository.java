package com.example.ibooksproject.repository;

import com.example.ibooksproject.models.book.Book;
import com.example.ibooksproject.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into books_likes values (?1, ?2)", nativeQuery = true)
    void addLike(@Param("user_id") int user_id, @Param("book_id") int book_id);

    @Modifying
    @Transactional
    @Query(value = "delete from books_likes where user_id = ?1 and book_id = ?2", nativeQuery = true)
    void deleteLike(@Param("user_id") int user_id, @Param("book_id") int book_id);

    @Modifying
    @Transactional
    @Query(value = "insert into books_dislikes values (?1, ?2)", nativeQuery = true)
    void addDislike(@Param("user_id") int user_id, @Param("book_id") int book_id);

    @Modifying
    @Transactional
    @Query(value = "delete from books_dislikes where user_id = ?1 and book_id = ?2", nativeQuery = true)
    void deleteDislike(@Param("user_id") int user_id, @Param("book_id") int book_id);
}

