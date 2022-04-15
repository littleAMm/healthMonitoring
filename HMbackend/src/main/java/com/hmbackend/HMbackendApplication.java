package com.hmbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class HMbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HMbackendApplication.class, args);
    }

}
