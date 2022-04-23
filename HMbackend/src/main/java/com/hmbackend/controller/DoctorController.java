package com.hmbackend.controller;

import com.hmbackend.bean.Doctor;
import com.hmbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

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
    @GetMapping("/allPatient")
    public String queryAllPatient(@RequestParam("doctorId")int doctorId){
        return doctorService.queryPatient(doctorId);
    }
    @PostMapping("/creatRx")
    public String creatRx(@RequestParam("patientId") int patientId,
                          @RequestParam("content") String content){
        return doctorService.creatRx(patientId,content);
    }
    @GetMapping("/checkDoctorInfo")//查看个人信息
    public String checkDoctorInfo(@RequestParam("doctorId")int doctorId){
        return doctorService.checkIfm(doctorId);
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
