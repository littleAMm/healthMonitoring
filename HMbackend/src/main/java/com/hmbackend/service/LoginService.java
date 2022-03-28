package com.hmbackend.service;

import com.hmbackend.bean.Patient;
import com.hmbackend.bean.User;
import com.hmbackend.mapper.LoginRegMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    @Autowired
    LoginRegMapper loginRegMapper;

    public String login(String username, String password) {
        User user = loginRegMapper.login(username, password);
        if (user == null) {
            return "用户名或密码错误，请重新输入";
        } else if (user.getRole().equals("管理员")) {
            return "/admin.html";
        } else if (user.getRole().equals("患者")) {
            return "/patient";
        } else if (user.getRole().equals("医生")) {
            return "/doctor";
        }
        return "/login";
    }

    //该注册界面仅用于患者注册，医生有管理员添加
    public String register(String username, String password,
                           String name, String sex) {
        if (loginRegMapper.queryUserByName(username) != null) {
            return "用户名重复，请重新输入";
        } else {
            User user = new User(username, password,"患者");
            Patient patient = new Patient(username, name, sex);
            loginRegMapper.register(user);
            loginRegMapper.regPatient(patient);
            return "注册成功";
        }
    }
}
