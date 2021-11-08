package com.example.ibooksproject.service;

import com.example.ibooksproject.models.user.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public boolean createUser(User user);
}
