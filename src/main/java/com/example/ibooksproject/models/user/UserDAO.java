package com.example.ibooksproject.models.user;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();

    public boolean createUser(User user) throws Exception;

    public User findByLogin(String login);

    public User findById(int id);

    public User findByEmail(String email);
}
