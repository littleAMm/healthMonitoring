package com.hmbackend.controller;

import com.hmbackend.service.LoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author_name:xiatao
 * @data:2022/3/24
 * @time:17:17
 */

@RestController
@Api(tags = "Login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
    public String login(@PathVariable("username") String username,
                        @PathVariable("password") String password) {
        String result = loginService.login(username, password);
        return result;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("name") String name,
                           @RequestParam("sex") String sex) {
        return loginService.register(username, password, name, sex);
    }
}
