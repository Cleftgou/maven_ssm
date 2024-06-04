package com.niu.controller;

import com.niu.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author bairimengchang
 * @version 1.0
 * @project maven_ssm
 * @description 用户控制器
 * @date 2024/5/14 14:31:24
 */
@Controller
@RequestMapping("/UserController")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam("uname") String uname,
                              @RequestParam("upwd") String upwd, HttpSession session) {

        Boolean b = userService.login(uname, upwd);
        if (b) {
            session.setAttribute("uname", uname);
            //重定向跳转学生服务器，跳过视图解析器
            return "redirect:/StudentController/getStuByPage/1";
        } else {
            session.setAttribute("error", "账号或密码错误");
            //重定向回登录界面
            return "login";
        }
    }

}
