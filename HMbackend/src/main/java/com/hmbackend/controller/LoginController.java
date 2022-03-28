package com.hmbackend.controller;

import com.hmbackend.service.LoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author_name:xiatao
 * @data:2022/3/24
 * @time:17:17 测试用
 */

@RestController
@Api(tags = "Login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletResponse response) throws IOException {
        String result = loginService.login(username, password);
        if (result.charAt(0) == '/') {
            response.sendRedirect(result);
            return "";
        } else {
            return result;
        }
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("role") String role) {
        return loginService.register(username, password, role);
    }
}
