package com.example.ibooksproject.repository;

import com.example.ibooksproject.models.book.Book;
import com.example.ibooksproject.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.login = ?1")
    User findByLogin(String login);

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

    @Modifying
    @Transactional
    @Query("update User u set u.likes = ?1 where u.id = ?2")
    void updateLikes(@Param("likes") Set<Book> likes, @Param("id") int id);

}
