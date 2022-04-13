package com.hmbackend.service;

import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Patient;
import com.hmbackend.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientService {
    @Autowired
    private PatientMapper patientMapper;

    public Patient queryPatientById(int patientId) {
        return patientMapper.queryPatientById(patientId);
    }

    public String addDoctor(int doctorId,int patientId){
        if(patientMapper.queryPatientById(patientId)==null){
            return"此患者未注册";
        }else{
            patientMapper.addDoctor(doctorId,patientId);
            return"添加成功";
        }
    }

    public Doctor queryDoctor(int userId) {
        return patientMapper.queryDoctor(userId);
    }

    public int deleteDoctor(int id) {
        return patientMapper.deleteDoctor(id);
    }

}
