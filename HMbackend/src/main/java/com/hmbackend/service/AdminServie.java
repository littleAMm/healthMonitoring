package com.hmbackend.service;

import com.alibaba.fastjson.JSON;
import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Patient;
import com.hmbackend.bean.User;
import com.hmbackend.mapper.AdminMapper;
import com.hmbackend.mapper.LoginRegMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public String addDoctor(String username, String name, String sex, String work) {
        if (loginRegMapper.queryUserByName(username) == null) {
            User user = new User(username, "123456", "医生");
            loginRegMapper.register(user);
            Doctor doctor = new Doctor(username, name, sex, work);
            adminMapper.addDoctor(doctor);
            return "添加成功";
        } else {
            return "用户名重复，请重新输入";
        }
    }
    public String queryAllDoctor() {
        String result = null;
        try {
            List<Doctor> list = adminMapper.queryAllDoctor();
            result = JSON.toJSONString(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public String queryPatient() {
        String result = null;
        try {
            List<Patient> list = adminMapper.queryPatient();
            result = JSON.toJSONString(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean deleteDoctor(String username) {
        if (adminMapper.deleteUser(username) != 0
                && adminMapper.deleteDoctor(username) != 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean deletePatient(String id) {
        if (adminMapper.deleteUser(id) != 0
                && adminMapper.deletePatient(id) != 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean updatePwd(String username) {
        if (adminMapper.updatePwd(username, "666666") != 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean updatePatient(String username, int age, int phone, String address) {
        if (adminMapper.updatePatient(username, age, phone, address) != 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean updateDoctor(String username, String work, int phone, String workTime) {
        if (adminMapper.updateDoctor(username, work, phone, workTime) != 0) {
            return true;
        } else {
            return false;
        }
    }
}
