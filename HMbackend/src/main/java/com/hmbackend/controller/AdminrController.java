package com.hmbackend.controller;

import com.hmbackend.service.AdminServie;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author_name:xiatao
 * @data:2022/3/26
 * @time:18:41
 */

@RestController
@RequestMapping("/admin")
public class AdminrController {
    @Autowired
    AdminServie adminServie;

    @RequestMapping(value = "/createDoctor",method = RequestMethod.POST)
    public String createDoctor(@RequestParam("id") int id,
                               @RequestParam("name")String name,
                               @RequestParam("sex") String sex,
                               @RequestParam("work") String work){
        return adminServie.createDoctor(id, name, sex, work);
    }
}
