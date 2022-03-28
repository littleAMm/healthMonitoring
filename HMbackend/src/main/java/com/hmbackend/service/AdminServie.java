package com.hmbackend.service;

import com.hmbackend.bean.Doctor;
import com.hmbackend.mapper.AdminMapper;
import com.hmbackend.mapper.LoginRegMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;

/**
 * @author_name:xiatao
 * @data:2022/3/26
 * @time:18:44
 */

@Service
public class AdminServie {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    LoginRegMapper loginRegMapper;

    public String createDoctor(String username, String name, String sex, String work) {
        if(loginRegMapper.queryUserByName(username)!=null){
            Doctor doctor = new Doctor(username,name,sex,work);
            adminMapper.addDoctor(doctor);
            return "添加成功";
        }else {
            return "用户名重复，请重新输入";
        }
    }

}
