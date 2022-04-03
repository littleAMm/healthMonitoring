package com.hmbackend.service;

import com.alibaba.fastjson.JSON;
import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Patient;
import com.hmbackend.mapper.DoctorMapper;
import com.hmbackend.mapper.PatientMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private PatientMapper patientMapper;
    //增加自己的患者
    public String addPatient(Doctor doctor,@Param("patient_id") String patientId){
        if(patientMapper.queryPatientById(patientId)==null){
            return"此患者未注册";
        }else{
            doctorMapper.addPatient(Integer.toString(doctor.getId()),patientId);
         return"添加成功";
        }
    }
    //展示自己的患者
    public String queryPatient(int doctorId){
        String result = null;
        try{
            List<String> list = doctorMapper.queryAllPatient(Integer.toString(doctorId));
            List<Patient>allPatient = null;
            for (String s:list) {
                allPatient.add(doctorMapper.queryPatientById(s));
            }
            result = JSON.toJSONString(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    //为患者创建处方
    public String creatRx(int patientId,String content){
        Patient patient = doctorMapper.queryPatientById(Integer.toString(patientId));
        if (patient==null){
            return "ID错误，请检查";
        }else{
            return "创建成功";
        }
    }

}
