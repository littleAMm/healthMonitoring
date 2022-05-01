package com.hmbackend.controller;

import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Patient;
import com.hmbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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

    @GetMapping("/info/{username}")
    Patient queryInfo(@PathVariable("username") String username) {
        return patientService.queryPatientByUsername(username);
    }

    @PostMapping("/updateInfo")
    String updateInfo(@RequestParam("id") int id,
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
    List<Doctor> queryAllDoctor(){
        return patientService.queryAllDoctor();
    }

    @PostMapping("/addDoctor")
    String addDoctor(@RequestParam("doctorId")int docID,
                     @RequestParam("patientId")int patID){
        if(patientService.addDoctor(docID,patID)){
            return "success";
        }else {
            return "error";
        }
    }

    @PostMapping
    String addHealth(@RequestParam("id")int id,
                     @RequestParam("temp")double temp,
                     @RequestParam("pulse")double pulse,
                     @RequestParam("date")Timestamp date){
        String status = null;
        if(temp>39&&pulse<70){
            status = "差";
        }else {
            status = "良好";
        }
        if(patientService.addHealth(id,status,temp,pulse,date)){
            return "success";
        }else {
            return "error";
        }
    }
}
