package com.hmbackend.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author_name:xiatao
 * @data:2022/3/25
 * @time:20:00
 */

@Data
@NoArgsConstructor
public class Patient{
    //注册用
    private String username;
    private int id;
    private String name;
    private String sex;

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
