package com.hmbackend.controller;

import com.hmbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/addPatient",method = RequestMethod.POST)
    public String addPatient(@RequestParam("patientId")String patientId){
        return doctorService.addPatient(patientId);
    }
}
