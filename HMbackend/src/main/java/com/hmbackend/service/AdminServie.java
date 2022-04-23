package com.hmbackend.service;

import com.alibaba.fastjson.JSON;
import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Patient;
import com.hmbackend.bean.User;
import com.hmbackend.mapper.AdminMapper;
import com.hmbackend.mapper.LoginRegMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    public String queryPatientUnhealthy() {
        String result = null;
        try {
            List<Patient> list = adminMapper.queryPatientUnhealthy();
            result = JSON.toJSONString(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteDoctor(@Param("username") String username) {
        if (adminMapper.deleteUser(username) != 0
                && adminMapper.deleteDoctor(username) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePatient(@Param("username") String username) {
        if (adminMapper.deleteUser(username) != 0
                && adminMapper.deletePatient(username) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updatePwd(@Param("username") String username){
        if (adminMapper.updatePwd(username, "666666")!=0){
            return true;
        }else {
            return false;
        }
    }

    public String  arrangeTime(int doctorId, Timestamp startTime,Timestamp endTime){
        Doctor doctor = adminMapper.queryDoctorById(doctorId);
        if (doctor==null){
            return "ID错误，请检查";
        }else if(startTime.before(endTime)){
            return "安排成功";
        }else {
            return "开始时间必须在结束时间之前";
        }
    }
}
