package com.niu.service;

import com.niu.pojo.Student;

import java.util.List;

/**
 * @author bairimengchang
 * @version 1.0
 * @project maven_ssm
 * @description
 * @date 2024/4/9 14:32:19
 */
public interface StudentService {
    //查询全部的学生
    List<Student> getAllStu();

    //删除学生
    boolean delStu(int stuNo);

    //编辑学生的详情界面
    Student editStu(Integer stuNo);

    boolean addStu(Student stu);
}