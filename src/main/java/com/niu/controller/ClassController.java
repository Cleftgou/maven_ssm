package com.niu.controller;

import com.alibaba.fastjson.JSONArray;
import com.niu.service.ClassService;
import com.niu.pojo.Class;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bairimengchang
 * @version 1.0
 * @project maven_ssm
 * @description 班级控制器
 * @date 2024/5/21 15:24:50
 */
@Controller
@RequestMapping("/ClassController")
public class ClassController {

    @Resource
    private ClassService classService;

    //不再走视图控制器,而是直接将数据写入到输入流中
    @ResponseBody//方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区
    @GetMapping(value = "/getAllCla", produces = "application/json;charset=utf-8")
    public String getAllCla() {
        List<Class> classList = classService.getAllCla();
        //写成json格式
        return JSONArray.toJSONString(classList);
    }

}
