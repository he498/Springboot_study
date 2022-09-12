package com.ming.controller;

import com.ming.pojo.User;
import com.ming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getUser")
    @ResponseBody
    public Map<String,List<User>> getUser(){
        List<User> list = userService.getUser();
        Map<String,List<User>> result = new HashMap<>();
        result.put("date",list);
        return result;
    }

    @RequestMapping("/getUserById/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") int id){
        User user = userService.getUserById(id);
        return user;
    }

    @PostMapping("/addUser")
    @ResponseBody
    public String addUser(User user){
        userService.addUser(user);
        return "OK";
    }

    @PostMapping("/updateUser")
    @ResponseBody
    public String updateUser(User user){
        userService.updateUser(user);
        return "OK";
    }

    @PostMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(int id){
        userService.deleteUser(id);
        return "OK";
    }


}
