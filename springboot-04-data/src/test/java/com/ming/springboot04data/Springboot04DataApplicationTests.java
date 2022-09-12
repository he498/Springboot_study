package com.ming.springboot04data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootTest
class Springboot04DataApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
//        数据源：class com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());
//        数据库链接
        Connection connection = dataSource.getConnection();
//        xxxx Template : springboot 已经配置好模板bean拿来即用

        connection.close();


    }

}
