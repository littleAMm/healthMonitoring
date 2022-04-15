package com.hmbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkTime {
    private int doctorId;
    private Timestamp startTime;
    private Timestamp endTime;
}
