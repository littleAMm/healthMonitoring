package com.hmbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Patient extends User{
    private String username;
    private int id;
    private String name;
    private String sex;

    public Patient(String username, String name, String sex) {
        this.username = username;
        this.name = name;
        this.sex = sex;
    }
}
