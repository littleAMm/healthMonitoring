package com.hmbackend.mapper;

import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    //添加医生
    int addDoctor(Doctor doctor);

}
