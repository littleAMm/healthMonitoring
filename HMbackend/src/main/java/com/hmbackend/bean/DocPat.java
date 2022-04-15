package com.hmbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author_name:xiatao
 * @data:2022/4/14
 * @time:13:56
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocPat {
    private int doctorId;
    private int patientId;
}
