package com.hmbackend.mapper;


import com.hmbackend.bean.Patient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorMapper {
    //添加自己的患者
    int addPatient(Patient patient);
    int deletePatient(Patient patient);
    //查询自己的患者
    List<Patient> queryAllPatient();
}
