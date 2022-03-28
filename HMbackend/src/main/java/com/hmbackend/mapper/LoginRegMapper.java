package com.hmbackend.mapper;


import com.hmbackend.bean.Patient;
import com.hmbackend.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginRegMapper {
    //注册到User表
    int register(User user);
    //注册到Patient表
    int regPatient(Patient patient);

    User queryUserByName(@Param("username") String username);

    //登录用
    User login(@Param("username") String username,@Param("password") String password);
}
