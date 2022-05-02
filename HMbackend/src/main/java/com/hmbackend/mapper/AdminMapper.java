package com.hmbackend.mapper;

import com.hmbackend.bean.Doctor;
import com.hmbackend.bean.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface AdminMapper {
    //添加医生
    int addDoctor(Doctor doctor);
    //删除医生或患者(需要联动删除)
    int deletePatient(@Param("username") String username);
    int deleteDoctor(@Param("username") String username);
    int deleteUser(@Param("username") String username);

    //忘记密码后进行重置密码(密码默认重置666666)
    int updatePwd(@Param("username") String username, @Param("password") String password);

    //查找患者健康状况为”差“的患者
    List<Patient> queryPatient();

    List<Doctor> queryAllDoctor();

    Doctor queryDoctorById(int id);

    Doctor queryDoctorByUsername(@Param("username") String username);
    Patient queryPatientByUsername(@Param("username") String username);
}
