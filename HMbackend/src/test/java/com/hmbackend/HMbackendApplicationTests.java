package com.hmbackend;

import com.hmbackend.bean.User;
import com.hmbackend.mapper.LoginRegMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HMbackendApplicationTests {


    @Autowired
    LoginRegMapper loginRegMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        User test = loginRegMapper.login("test", "1");
        if(test.getRole().equals("医生"))
        {

        }
    }

}
