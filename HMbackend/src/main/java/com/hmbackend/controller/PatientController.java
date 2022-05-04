package com.hmbackend.controller;

import com.alibaba.fastjson.JSON;
import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Health;
import com.hmbackend.bean.Patient;
import com.hmbackend.service.AdminServie;
import com.hmbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    AdminServie adminServie;

    @GetMapping("/info/{username}")
    public String queryInfo(@PathVariable("username") String username) {
        Patient patient = patientService.queryPatientByUsername(username);
        return JSON.toJSONString(patient);
    }

    @PostMapping("/updateInfo")
    public String updateInfo(@RequestParam("id") int id,
                             @RequestParam("age") int age,
                             @RequestParam("phoneNumber") int phoneNumber,
                             @RequestParam("address") String address) {
        if (patientService.updateInfo(id, age, phoneNumber, address)) {
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/allDoctors")
    public String queryAllDoctor() {
        return adminServie.queryAllDoctor();
    }

    @PostMapping("/addDoctor")
    public String addDoctor(@RequestParam("doctorId") int docID,
                            @RequestParam("patientId") int patID) {
        if (patientService.addDoctor(docID, patID)) {
            return "success";
        } else {
            return "error";
        }
    }

    @PostMapping("/addHealth")
    public String addHealth(@RequestParam("id") int id,
                            @RequestParam("temp") double temp,
                            @RequestParam("pulse") double pulse,
                            @RequestParam("date") String date) {
        String status = null;
        if (temp > 39 && pulse < 70) {
            status = "差";
        } else {
            status = "良好";
        }
        if (patientService.addHealth(id, status, temp, pulse, date)
                && patientService.addStatus(id,status)) {
            return "success";
        } else {
            return "error";
        }
    }

    @PostMapping("/deleteHealth")
    public String deleteHealth(@RequestParam("id") int id,
                               @RequestParam("index") int index) {
        if (patientService.deleteHealth(id, index)) {
            return "success";
        } else {
            return "false";
        }
    }

    @GetMapping("/selectedDoctor/{patientId}")
    public Doctor querySelectedDoctor(@PathVariable("patientId") int id) {
        return patientService.queryDoctorSelected(id);
    }

    @GetMapping("/allHealth/{patientId}")
    public List<Health> queryAllHealth(@PathVariable("patientId") int id) {
        return patientService.queryAllHealth(id);
    }
}
