package com.hmbackend.controller;

import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Patient;
import com.hmbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/checkPatientInfo")
    public Patient checkPatientInfo(@RequestParam("patientId")int patientId) {
        return patientService.queryPatientById(patientId);
    }

    @PostMapping(value = "/addPatientDoctor")
    public String addPatientDoctor(@RequestParam("doctorId")int doctorId,
                                    @RequestParam("patientId")int patientId) {
        return patientService.addDoctor(doctorId,patientId);
    }

    @GetMapping(value = "/queryDoctor")
    public Doctor getUserDoctor(@RequestParam("patientId")int patientId) {
        return patientService.queryDoctor(patientId);
    }

    @PostMapping(value = "/deletePatientDoctor")
    public int deletePatientDoctor(int id) {
        return patientService.deleteDoctor(id);
    }
}
