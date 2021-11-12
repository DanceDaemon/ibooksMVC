package com.example.ibooksproject.models.user;

import com.example.ibooksproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements UserDAO {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean createUser(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

}
