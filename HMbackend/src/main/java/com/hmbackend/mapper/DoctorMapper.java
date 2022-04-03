package com.hmbackend.mapper;


import com.hmbackend.bean.Patient;
import com.hmbackend.bean.Rx;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface DoctorMapper {
    //添加自己的患者
    void addPatient(@Param("doctor_id") String doctorId,@Param("patient_id") String patientId);
    //查询自己的患者
    List<String> queryAllPatient(@Param("doctor_id") String doctorId);
    Patient queryPatientById(@Param("patient_id") String patientId);
    //创建处方
    void addRx(Rx rx);
}
