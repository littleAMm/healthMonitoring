package com.hmbackend.controller;

import com.hmbackend.bean.Patient;
import com.hmbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author_name:xiatao
 * @data:2022/4/14
 * @time:14:23
 */

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/info")
    Patient queryInfo(@RequestParam("username") String username){
        return patientService.queryPatientByUsername(username);
    }
}
