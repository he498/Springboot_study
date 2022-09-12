package com.ming.dao;

import com.ming.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> getUser();
    User getUserById(@Param("id") int id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
