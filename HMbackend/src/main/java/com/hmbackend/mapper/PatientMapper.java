package com.hmbackend.mapper;

import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Health;
import com.hmbackend.bean.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PatientMapper {
    Patient queryPatientById(@Param("patientid") int patientid);

    void addDoctor(@Param("doctor_id") int doctorId,@Param("patient_id") int patientId);

    Doctor queryDoctor(@Param("doctor_id")int doctorId);

    int deleteDoctor(@Param("id") int id);

    void creatHealth(Health health);
}
