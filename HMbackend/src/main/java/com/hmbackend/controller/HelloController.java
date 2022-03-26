package com.hmbackend.controller;

import com.hmbackend.bean.User;
import com.hmbackend.mapper.LoginRegMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author_name:xiatao
 * @data:2022/3/24
 * @time:17:17
 * 测试用
 */

@RestController
@Api(tags = "HelloController")
public class HelloController {
    @Autowired
    LoginRegMapper loginRegMapper;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation("hello")
    public String hello(@RequestParam("username") String username,
                        @RequestParam("password") String password){
        User user = loginRegMapper.login(username, password);
        if (user.getRole().equals("医生")){
            return "redirect:/doctor.html";
        }else {
            return "失败";
        }
    }
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public String reg(@RequestParam("username") String username,
                      @RequestParam("password") String password){
        User user = new User(username,password);
        if(loginRegMapper.register(user)==1){
            return "注册成功";
        }
        else{
            return "false";
        }
    }
}
