package com.hmbackend.controller;

import com.hmbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
}
