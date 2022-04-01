package com.hmbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author_name:xiatao
 * @data:2022/4/1
 * @time:16:39
 * @Description:医生工作安排
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkTime {
    private int doctorId;
    private Timestamp startTime;
    private Timestamp endTime;
}
