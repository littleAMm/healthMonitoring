package com.hmbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor{
    private String username;
    private int id;
    private String name;
    private String sex;
    private String work;
    private List<Patient> patients;

    public Doctor(String username, String name, String sex, String work) {
        this.username = username;
        this.name = name;
        this.sex = sex;
        this.work = work;
    }
    public int getId() {
        return id;
    }
}
