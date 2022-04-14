package com.hmbackend.service;

import com.hmbackend.bean.Patient;
import com.hmbackend.mapper.AdminMapper;
import com.hmbackend.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author_name:xiatao
 * @data:2022/4/14
 * @time:14:23
 */
@Service
public class PatientService {
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    AdminMapper adminMapper;

    public Patient queryPatientByUsername(String username){
        return adminMapper.queryPatientByUsername(username);
    }

}
