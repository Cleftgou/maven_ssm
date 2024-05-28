package com.niu.mapper;

import com.niu.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author bairimengchang
 * @version 1.0
 * @project maven_ssm
 * @description
 * @date 2024/4/9 14:19:05
 */
@Repository
public interface StudentMapper {
    //查询全部的学生
    List<Student> selectAll();

    //根据任意条件查询学生(姓名，年龄，班级，班级简介)
    List<Student> getStuBy(Map<String, Object> map);

    //根据学生的姓名查询，只要姓名和年龄（条件可有可无）
    List<Student> getStuByName(String stuName);


    //查询指定id的方法，1001，1002，6005，2002
    List<Student> getStuByIds(@Param("ids") List<Integer> ids);

    //学生信息录入
    int addStu(Student student);

    //学生信息的删除
    int delStu(Integer stuNo);

    //根据学号查学生
    Student selectOneStudentByStuNo(Integer stuNo);

    //真正的修改学生方法
    int updateStu(Student student);
}
