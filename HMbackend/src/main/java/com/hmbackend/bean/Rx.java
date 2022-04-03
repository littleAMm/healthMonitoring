package com.hmbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author_name:xiatao
 * @data:2022/4/1
 * @time:16:08
 * @description:处方类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rx {
    private int patientId;
    private String content;//处方内容
}
