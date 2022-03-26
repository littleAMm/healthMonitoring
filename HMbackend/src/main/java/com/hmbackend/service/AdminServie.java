package com.hmbackend.service;

import com.hmbackend.bean.Doctor;
import com.hmbackend.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author_name:xiatao
 * @data:2022/3/26
 * @time:18:44
 */

@Service
public class AdminServie {
    @Autowired
    AdminMapper adminMapper;

    public String createDoctor(int id,String name,String sex,String work){
        Doctor doctor = new Doctor(id,name,sex,work);
        if (adminMapper.queryDoctorByID(id)!=null){
            return "添加失败，医生id重复";
        }else{
            adminMapper.addDoctor(doctor);
            return "添加成功";
        }
    }

}
