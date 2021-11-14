package com.example.ibooksproject.service.user;

import com.example.ibooksproject.models.user.CustomUserDetails;
import com.example.ibooksproject.models.user.User;
import com.example.ibooksproject.models.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        userDAO.createUser(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userDAO.findByLogin(login);

        return new CustomUserDetails(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    @Override
    public User getUserById(int id) {
        return userDAO.findById(id);
    }
}
