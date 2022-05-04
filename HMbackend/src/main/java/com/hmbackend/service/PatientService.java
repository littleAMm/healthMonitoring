package com.hmbackend.service;

import com.hmbackend.bean.DocPat;
import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Health;
import com.hmbackend.bean.Patient;
import com.hmbackend.mapper.AdminMapper;
import com.hmbackend.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Patient queryPatientByUsername(String username) {
        return adminMapper.queryPatientByUsername(username);
    }

    public boolean updateInfo(int id, int age, int phNum, String address) {
        if (patientMapper.updatePatientInfo(id, age, phNum, address) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addHealth(int id, String status, double temp, double pulse, String date) {
        if (patientMapper.addHeath(id, status, temp, pulse, date) != 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean addStatus(int id,String status){
        if(patientMapper.updateStatus(id,status)!=0){
            return true;
        }else {
            return false;
        }
    }

    public Doctor queryDoctorSelected(int id) {
        DocPat docPat = patientMapper.queryDoctorId(id);
        Doctor doctor = patientMapper.queryDoctorById(docPat.getDoctorId());
        return doctor;
    }

    public boolean addDoctor(int docId, int patId) {
        if (patientMapper.addDoctor(docId, patId) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Health> queryAllHealth(int id) {
        return patientMapper.queryAllHealth(id);
    }

    public boolean deleteHealth(int id, int index) {
        if (patientMapper.deleteHealth(id, index) != 0) {
            return true;
        } else {
            return false;
        }
    }
}
