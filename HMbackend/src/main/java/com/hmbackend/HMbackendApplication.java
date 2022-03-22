package com.hmbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.hmbackend.mapper"})
public class HMbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HMbackendApplication.class, args);
    }

}
