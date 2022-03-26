package com.hmbackend.mapper;


import com.hmbackend.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginRegMapper {
    //注册用
    int register(User user);
    int queryUserByName(@Param("username") String username);

    //登录用
    User login(@Param("username") String username,@Param("password") String password);
}
