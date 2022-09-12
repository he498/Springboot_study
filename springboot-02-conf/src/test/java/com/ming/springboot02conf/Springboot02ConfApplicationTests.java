package com.ming.springboot02conf;

import com.ming.springboot02conf.pojo.Dog;
import com.ming.springboot02conf.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//Person{
//    name='ming',
//        age=6,
//        happy=false,
//        birth=Thu Sep 02 00:00:00 CST 2021,
//        maps={k1=v1, k2=v2},
//        lists=[code, music, girl],
//        dog=Dog{name='富贵', age=3}}


@SpringBootTest
class Springboot02ConfApplicationTests {
    @Autowired
    private Person person;
    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
