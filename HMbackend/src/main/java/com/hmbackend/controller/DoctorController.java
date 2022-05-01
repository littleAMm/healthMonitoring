package com.hmbackend.controller;

import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Patient;
import com.hmbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/addPatient",method = RequestMethod.POST)
    public String addPatient(@RequestParam("doctorId")int doctorId,
                             @RequestParam("patientId")int patientId){
        return doctorService.addPatient(doctorId,patientId);
    }
    @RequestMapping(value="/allPatient",method= RequestMethod.GET)
    public List<Patient> queryAllPatient(@RequestParam("doctorId")int doctorId){
//        List<Patient>list=new ArrayList<Patient>();
//        list=doctorService.queryPatient(doctorId);
        return doctorService.queryPatient(doctorId);
    }
    @RequestMapping(value="/creatRx",method= RequestMethod.POST)
    public String creatRx(@RequestParam("patient_id") int patientId,
                          @RequestParam("diagnose") String diagnose,
                          @RequestParam("content") String content){
        return doctorService.creatRx(patientId,content,diagnose);
    }
    @PostMapping("/checkDoctorInfo")//查看个人信息
    public Doctor checkDoctorInfo(@RequestParam("username")String username){
        return doctorService.checkIfm(username);
    }
    @PostMapping("/changeDoctorInfo/changeUsername")
    public String changeUsername(@RequestParam("username") String uesrname,
                                 @RequestParam("doctorId")int doctorId){
        return doctorService.changeUsername(doctorId,uesrname);
    }
    @PostMapping("/changeDoctorInfo/changeName")
    public String changeName(@RequestParam("name") String name,
                             @RequestParam("doctorId")int doctorId){
        return doctorService.changeName(doctorId,name);
    }
    @PostMapping("/changeDoctorInfo/changeSex")
    public String changeSex(@RequestParam("sex") String sex,
                            @RequestParam("doctorId")int doctorId){
        return doctorService.changesex(doctorId,sex);
    }
    @PostMapping("/changeDoctorInfo/changeWork")
    public String changeWork(@RequestParam("work") String work,
                             @RequestParam("doctorId")int doctorId){
        return doctorService.changeWork(doctorId,work);
    }
}
