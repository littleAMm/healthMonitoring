package com.hmbackend.mapper;

import com.hmbackend.bean.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PatientMapper {
    Patient queryPatientById(@Param("patientid") String patientid);
}
