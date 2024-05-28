package com.niu.controller;

import com.niu.pojo.Student;
import com.niu.service.StudentService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author bairimengchang
 * @version 1.0
 * @project maven_ssm
 * @description 学生控制器
 * @date 2024/5/14 14:31:42
 */
@Controller
@RequestMapping("/StudentController")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/selectAll")
    public ModelAndView index(ModelAndView modelAndView) {
        List<Student> students = studentService.getAllStu();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("student");
        return modelAndView;
    }

    //编辑功能
    @PostMapping("/updateStu")
    public String upload(Student student, @RequestParam("myFile") MultipartFile myFile, HttpSession session) throws IOException {
        //上传文件的名字
        String originalFilename = myFile.getOriginalFilename();

        //判断这个文件名是否为空
        if (!"".equals(originalFilename)) {
            //获取路径
            String realPath = session.getServletContext().getRealPath("/images/");

            //把服务器路径封装成文件对象
            File file = new File(realPath);
            //文件不存在，则创建文件夹
            if (!file.exists()) {
                file.mkdirs();
            }
            //把路径加文件名封装一下
            File sessionFile = new File(file, originalFilename);

            //传递该文件的内容
            myFile.transferTo(sessionFile);

            //完成录入的过程
            student.setStuImg(originalFilename);
        }

        studentService.updateStu(student);

        //跳转回主页面
        return "redirect:/StudentController/selectAll";
    }

    @GetMapping("/delete/{stuNo}")
    public String delete(@PathVariable("stuNo") Integer stuNo) {
        studentService.delStu(stuNo);
        //重定向（发请求）回学生服务器全查
        return "redirect:/StudentController/selectAll";
    }

    @GetMapping("/edit/{stuNo}")
    public ModelAndView edit(@PathVariable("stuNo") Integer stuNo, ModelAndView modelAndView) {
        Student student = studentService.editStu(stuNo);
        modelAndView.addObject("student", student);
        modelAndView.setViewName("studentDetail");
        return modelAndView;
    }

    @PostMapping("/addStu")
    public String add(Student student, @RequestParam("myFile") MultipartFile myFile, HttpSession session) throws IOException {
        //上传文件的名字
        String originalFilename = myFile.getOriginalFilename();
        //获取路径
        String realPath = session.getServletContext().getRealPath("/images/");

        //把服务器路径封装成文件对象
        File file = new File(realPath);
        //文件不存在，则创建文件夹
        if (!file.exists()) {
            file.mkdirs();
        }
        //把路径加文件名封装一下
        File sessionFile = new File(file, originalFilename);

        //传递该文件的内容
        myFile.transferTo(sessionFile);

        //完成录入的过程
        student.setStuImg(originalFilename);
        studentService.addStu(student);

        //跳转回主页面
        return "redirect:/StudentController/selectAll";
    }



}
