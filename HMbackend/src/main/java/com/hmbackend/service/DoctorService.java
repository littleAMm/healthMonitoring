package com.hmbackend.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Patient;
import com.hmbackend.mapper.DoctorMapper;
import com.hmbackend.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private PatientMapper patientMapper;
    public String addPatient(String patientId){
        if(patientMapper.queryPatientById(patientId)==null){
            return"此患者未注册";
        }else{
         return"";
        }

    }
}
