package com.example.ibooksproject.service;

import com.example.ibooksproject.models.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> findAll();
    public boolean createUser(User user);
}
