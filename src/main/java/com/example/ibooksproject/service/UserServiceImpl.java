package com.example.ibooksproject.service;

import com.example.ibooksproject.models.user.CustomUserDetails;
import com.example.ibooksproject.models.user.User;
import com.example.ibooksproject.models.user.UserDAO;
import com.example.ibooksproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDAO.findByLogin(login);

        return new CustomUserDetails(user);
    }
}
