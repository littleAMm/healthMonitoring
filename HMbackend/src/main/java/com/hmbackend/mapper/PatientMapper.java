package com.hmbackend.mapper;

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
    Patient queryPatientById(@Param("patientid") String patientid);
}
