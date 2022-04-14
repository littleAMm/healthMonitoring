package com.hmbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author_name:xiatao
 * @data:2022/4/1
 * @time:16:06
 * @decription:用来记录患者的健康状况
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Health {
    private int patientId;
    private double temp;
    //体温
    private String status;
    //标志位，用来判读是否健康
}
