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
    private String age;
    private String symptom;
    private String phone_number;
    private String address;

    //后续添加
    //症状（医生添加）
    private String symptom;
    private int age;
    private String address;
    private int phoneNumber;


    public Patient(String username, String name, String sex) {
        this.username = username;
        this.name = name;
        this.sex = sex;
    }
}
