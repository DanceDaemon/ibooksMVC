package com.example.ibooksproject.models.user;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();

    public boolean createUser(User user);

}
