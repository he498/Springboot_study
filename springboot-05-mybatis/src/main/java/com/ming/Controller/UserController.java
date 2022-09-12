package com.ming.Controller;

import com.ming.dao.UserMapper;
import com.ming.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper mapper;

    @GetMapping("/getUser")
    public List<User> queryUserList(){
        List<User> list = mapper.queryUserList();
        return list;
    }
    @GetMapping("/getUserById/{id}")
    public User queryUserById(@PathVariable("id") int id){
        User user = mapper.queryUserById(id);
        return user;
    }

    @GetMapping("/addUser")
    public String addUser(){
        User user = new User(6,"zzming","123456");
        mapper.addUser(user);
        return "add-OK";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id")int id){
        mapper.updateUser(new User(id,"zzz","11111"));
        return "update-OK";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")int id){
        mapper.deleteUser(id);
        return "delete-ok";
    }

}
