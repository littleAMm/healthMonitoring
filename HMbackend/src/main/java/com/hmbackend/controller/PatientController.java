package com.hmbackend.controller;

import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Patient;
import com.hmbackend.service.PatientService;
import org.apache.ibatis.annotations.Param;
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

    @GetMapping("/queryInfo")
    Patient queryInfo(@RequestParam("username") String username) {
        return patientService.queryPatientByUsername(username);
    }

    @PostMapping("/addDoctor")
    String addDoctor(@RequestParam("doctorId")int docId,
                     @RequestParam("patientId")int patId){
        if(patientService.addDoctor(docId, patId)){
            return "success";
        }else{
            return "error";
        }
    }

    @PostMapping("/updateInfo")
    String updateInfo(@RequestParam("id") int id,
                      @RequestParam("age") int age,
                      @RequestParam("phoneNumber") int phNum,
                      @RequestParam("address") String address) {
        if (patientService.updateInfo(id, age, phNum, address)) {
            return "success";
        }else {
            return "error";
        }
    }

    @PostMapping("/addHealth")
    String addHealth(@RequestParam("id") int id,
                     @RequestParam("status") String status,
                     @RequestParam("temp") double temp,
                     @RequestParam("pulse")double pulse,
                     @RequestParam("date")Timestamp date){
        if(patientService.addHealth(id, status, temp, pulse, date)){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/queryDoctorSelected")
    List<Doctor> queryDoctorSelected(@Param("id") int id){
        return patientService.queryDoctorSelected(id);
    }

    @GetMapping("/queryAllDoctor")
    List<Doctor> queryAllDoctor(){
        return patientService.queryAllDoctor();
    }
}
