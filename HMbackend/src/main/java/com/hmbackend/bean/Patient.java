package com.hmbackend.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Patient{
    //注册用
    private String username;
    private int id;
    private String name;
    private String sex;
    private int age;
    private String symptom;
    private long phoneNumber;
    private String address;
    private String status;
    public Patient(String username, String name, String sex) {
        this.username = username;
        this.name = name;
        this.sex = sex;
    }
}
