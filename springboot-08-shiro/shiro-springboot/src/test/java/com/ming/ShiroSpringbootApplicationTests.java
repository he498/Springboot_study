package com.ming;

import com.ming.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.soap.Addressing;

@SpringBootTest
class ShiroSpringbootApplicationTests {
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        System.out.println(userService.queryUserByName("ming"));
    }

}
