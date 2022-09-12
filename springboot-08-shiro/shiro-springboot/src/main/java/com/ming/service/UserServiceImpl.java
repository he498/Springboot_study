package com.ming.service;

import com.ming.dao.UserMapper;
import com.ming.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}
