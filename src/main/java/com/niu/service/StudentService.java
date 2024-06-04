package com.niu.service;

import com.github.pagehelper.PageInfo;
import com.niu.pojo.Student;

import java.util.List;
import java.util.Map;

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
    //根据学号查询
    Student editStu(Integer stuNo);

    //修改
    boolean updateStu(Student stu);

    boolean addStu(Student stu);

    //定义一个分页的业务
    PageInfo<Student> getStuByPage(int pageNow, int pageSize, Map<String,Object> map);
}
