package com.ming.controller;


import com.ming.pojo.User;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @ApiOperation("Hello控制类")
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    //只要接口中返回值存在实体类，他就会被扫描到Swagger中
    @PostMapping("/user")
    public User user(){
        return new User();
    }
    @ApiOperation("post测试类")
    @PostMapping("/postt")
    public String post(@ApiParam("用户名")@RequestParam("username") String username,@ApiParam("密码")@RequestParam("pwd")String pwd){
        return username+pwd;
    }


}
