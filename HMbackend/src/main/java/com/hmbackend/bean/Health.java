package com.hmbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Health {
    private int patientId;
    private double temp;//体温
    private String status;//标志位，用来判读是否健康
}
