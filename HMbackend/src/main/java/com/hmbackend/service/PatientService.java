package com.hmbackend.service;

import com.hmbackend.bean.DocPat;
import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Patient;
import com.hmbackend.mapper.AdminMapper;
import com.hmbackend.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
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
        return (Patient) adminMapper.queryPatientByUsername(username);
    }

    public boolean updateInfo(int id, int age, int phNum, String address) {
        if (patientMapper.updatePatientInfo(id, age, phNum, address) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addHealth(int id, String status, double temp, double pulse, Timestamp date){
        if(patientMapper.addHeath(id, status, temp, pulse, date)!=0){
            return true;
        }else {
            return false;
        }
    }

    public List<Doctor> queryDoctorSelected(int id){
        List<DocPat> docPats = patientMapper.queryDoctorId(id);
        List<Doctor> doctors = new ArrayList<Doctor>();
        for(DocPat doc : docPats){
            Doctor doctor = adminMapper.queryDoctorById(doc.getDoctorId());
            doctors.add(doctor);
        }
        return doctors;
    }

    public boolean addDoctor(int docId,int patId){
        if(patientMapper.addDoctor(docId,patId)!=0){
            return true;
        }else {
            return false;
        }
    }
    public List<Doctor> queryAllDoctor(){
        return adminMapper.queryAllDoctor();
    }
}
