package com.hmbackend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author_name:xiatao
 * @data:2022/3/24
 * @time:17:17
 * 测试用
 */

@RequestMapping("/hello")
@RestController
@Api(tags = "HelloController")
public class HelloController {
    @RequestMapping("/t1")
    @ApiOperation("hello")
    public String hello(){
        return "hello";
    }
}
