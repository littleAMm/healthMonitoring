package com.hmbackend.controller;

import com.hmbackend.service.AdminServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
/**
 * @author_name:xiatao
 * @data:2022/3/26
 * @time:18:41
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminServie adminServie;

    @RequestMapping(value = "/addDoctor", method = RequestMethod.POST)
    public String createDoctor(@RequestParam("username") String username,
                               @RequestParam("name") String name,
                               @RequestParam("sex") String sex,
                               @RequestParam("work") String work) {
        return adminServie.addDoctor(username, name, sex, work);
    }

    @GetMapping("/allDoctor")
    public String queryAllDoctor() {
        return adminServie.queryAllDoctor();
    }

    @GetMapping("/allPatient")
    public String queryPatient() {
        return adminServie.queryPatient();
    }

    @PostMapping("/deleteDoctor")
    @Transactional
    public String deleteDoctor(@RequestParam("username") String username) {
        if (adminServie.deleteDoctor(username)) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @PostMapping("/deletePatient")
    @Transactional
    public String deletePatient(@RequestParam("username") String username) {
        if (adminServie.deletePatient(username)) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @PostMapping("/updatePwd")
    @Transactional
    public String updatePwd(@RequestParam("username") String username) {
        if (adminServie.updatePwd(username)) return "修改成功";
        else return "修改失败";
    }
}
