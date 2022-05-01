package com.hmbackend;

import com.hmbackend.bean.Patient;
import com.hmbackend.bean.User;
import com.hmbackend.mapper.DoctorMapper;
import com.hmbackend.mapper.LoginRegMapper;
import com.hmbackend.service.DoctorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HMbackendApplicationTests {


    @Autowired
    LoginRegMapper loginRegMapper;
    @Autowired
    DoctorService doctorMapper;
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void test() {
//        User test = loginRegMapper.login("test", "1");
//        if(test.getRole().equals("医生"))
//        {
//
//        }
//    }
    @Test
    void tset(){
        doctorMapper.creatRx(201,"owhdfAHOFO","auewfhaowhfoauh");
    }
}
