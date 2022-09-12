package com.ming.service;


import com.ming.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getUser();
    User getUserById(int id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
