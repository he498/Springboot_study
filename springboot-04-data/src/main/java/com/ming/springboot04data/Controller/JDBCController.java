package com.ming.springboot04data.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/list")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";
        List<Map<String,Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into user(id,name,pwd) values (6,'小明','123456') ";
        jdbcTemplate.update(sql);
        return "OK";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update user set name = ?, pwd = ? where id ="+id;
        Object[] objects = new Object[2];
        objects[0] = "大明";
        objects[1] = "11111";
        jdbcTemplate.update(sql,objects);
        return "update-OK";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql,id);
        return "delete-OK";
    }




}
