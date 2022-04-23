package com.hmbackend.mapper;

import com.hmbackend.bean.DocPat;
import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author_name:xiatao
 * @data:2022/3/26
 * @time:12:55
 */

@Mapper
public interface PatientMapper {
    Patient queryPatientById(@Param("patientId") int patientId);

    int addDoctor(@Param("doctorId") int doctorId, @Param("patientId") int patientId);

    Doctor queryDoctorById(@Param("doctorId") int doctorId);

    int deleteDoctor(@Param("id") int id);

    int addHeath(@Param("patientId") int id, @Param("status") String status, @Param("temp") double temp, @Param("pulse") double pulse, @Param("date") Timestamp date);

    int updatePatientInfo(@Param("patientId") int id, @Param("age") int age, @Param("phoneNumber") int phNum, @Param("address") String address);

    List<DocPat> queryDoctorId(@Param("patient") int id);
}
