package com.hmbackend.mapper;

import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Patient;
import com.hmbackend.bean.Rx;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface DoctorMapper {

    //添加自己的患者
    void addPatient(@Param("doctor_id") int doctorId,@Param("patient_id") int patientId);

    //查询自己的患者
    List<Integer> queryAllPatient(@Param("doctor_id") int doctorId);
    Patient queryPatientById(@Param("patient_id") int patientId);

    //创建处方
    void addRx(@Param("patient_id") int patientId,@Param("content") String content,@Param("diagnose") String diagnose);

    //修改自己的个人信息
    String changeSelfIfm(@Param("doctor_username") String doctorUsername,@Param("doctor_name") String name,@Param("doctor_sex") String doctorSex,@Param("doctor_work") String doctorWork,@Param("doctor_id") int doctorId);

    //查询自己的个人信息
    Doctor checkIfm(@Param("username") String username);
    Doctor queryDoctorById(int id);
}
