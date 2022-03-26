package com.hmbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends User{
    private int id;
    private String name;
    private String sex;
    private String work;
}
