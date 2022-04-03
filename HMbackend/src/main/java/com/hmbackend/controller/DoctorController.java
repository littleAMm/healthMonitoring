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
    public String addPatient(Doctor doctor, @RequestParam("patientId")String patientId){
        return doctorService.addPatient(doctor,patientId);
    }
    @GetMapping("/allPatient")
    public String queryAllPatient(Doctor doctor){
        return doctorService.queryPatient(doctor.getId());
    }
    @PostMapping("/creatRx")
    public String creatRx(@RequestParam("patientId") int patientId,
                          @RequestParam("content") String content){
        return doctorService.creatRx(patientId,content);
    }
}
