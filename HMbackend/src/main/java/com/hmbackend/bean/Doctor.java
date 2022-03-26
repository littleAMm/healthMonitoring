package com.hmbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author_name:xiatao
 * @data:2022/3/25
 * @time:18:25
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends User{
    private int id;
    private String name;
    private String sex;
    private String work;
}
