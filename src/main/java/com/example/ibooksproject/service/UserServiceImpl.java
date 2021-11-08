package com.example.ibooksproject.service;

import com.example.ibooksproject.models.user.User;
import com.example.ibooksproject.models.user.UserDAO;
import com.example.ibooksproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public boolean createUser(User user) {
        return userDAO.createUser(user);
    }
}
