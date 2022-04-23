package com.hmbackend.service;

import com.alibaba.fastjson.JSON;
import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Patient;
import com.hmbackend.bean.Rx;
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

    //增加自己的患者，如果未注册返回
    public String addPatient(int doctorId,int patientId){
        if(patientMapper.queryPatientById(patientId)==null){
            return"此患者未注册";
        }else{
            doctorMapper.addPatient(doctorId,patientId);
         return"添加成功";
        }
    }

    //展示自己的患者
    public String queryPatient(int doctorId){
        String result = null;
        try{
            List<Integer> list = doctorMapper.queryAllPatient(doctorId);
            List<Patient>allPatient = null;
            for (int s:list) {
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
        Patient patient = doctorMapper.queryPatientById(patientId);
        if (patient==null){
            return "ID错误，请检查";
        }else{
            Rx rx=new Rx(patientId,content);
            doctorMapper.addRx(rx);
            return "创建成功";
        }
    }

    //修改个人信息
    public String changeUsername(int doctorId,String username){
        if(doctorMapper.queryDoctorById(doctorId)==null){
            return"此医生不存在";
        }else{
        Doctor doctor=doctorMapper.queryDoctorById(doctorId);
        return doctorMapper.changeSelfIfm(username,doctor.getName(),doctor.getSex(),doctor.getWork(),doctorId);
        }
    }
    public String changeName(int doctorId,String name){
        if(doctorMapper.queryDoctorById(doctorId)==null){
            return"此医生不存在";
        }else{Doctor doctor=doctorMapper.queryDoctorById(doctorId);
            return doctorMapper.changeSelfIfm(doctor.getUsername(),name,doctor.getSex(),doctor.getWork(),doctorId);
        }
    }
    public String changesex(int doctorId,String sex){
        if(doctorMapper.queryDoctorById(doctorId)==null){
            return"此医生不存在";
        }else{Doctor doctor=doctorMapper.queryDoctorById(doctorId);
            return doctorMapper.changeSelfIfm(doctor.getUsername(),doctor.getName(),sex,doctor.getWork(),doctorId);
        }
    }
    public String changeWork(int doctorId,String work){
        if(doctorMapper.queryDoctorById(doctorId)==null){
            return"此医生不存在";
        }else{Doctor doctor=doctorMapper.queryDoctorById(doctorId);
            return doctorMapper.changeSelfIfm(doctor.getUsername(),doctor.getName(),doctor.getSex(),work,doctorId);
        }
    }

    //查询个人信息
    public String checkIfm(int doctorId){
        if(doctorMapper.queryDoctorById(doctorId)==null){
            return"此医生不存在";
        }else{
            doctorMapper.checkIfm(doctorId);
            return "成功";
        }
    }
}
