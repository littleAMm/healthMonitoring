package com.hmbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Patient{
    private String username;
    private int id;
    private String name;
    private String sex;
    private String age;
    private String symptom;
    private String phone_number;
    private String address;

    public Patient(String username, String name, String sex) {
        this.username = username;
        this.name = name;
        this.sex = sex;
    }
}
