package com.hmbackend.controller;

import com.hmbackend.bean.Patient;
import com.hmbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/info/{username}")
    Patient queryInfo(@PathVariable("username") String username){
        return patientService.queryPatientByUsername(username);
    }

//    @GetMapping
}
