package com.hmbackend.mapper;

import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Health;
import com.hmbackend.bean.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author_name:xiatao
 * @data:2022/3/26
 * @time:12:55
 */

@Mapper
public interface PatientMapper {
    Patient queryPatientById(@Param("patientId") int patientId);

    int addDoctor(@Param("doctorId") int doctorId,@Param("patientId") int patientId);

    Doctor queryDoctorById(@Param("doctorId")int doctorId);

    int deleteDoctor(@Param("id") int id);

    int creatHealth(Health health);

    int updateHeath(@Param("patientId") int id, @Param("status") String status,@Param("temp") double temp);
}
