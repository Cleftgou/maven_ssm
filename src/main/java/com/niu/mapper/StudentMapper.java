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
    //分页插件会把全查改成分页查询
    List<Student> selectAll(Map<String,Object> map);

    //学生信息录入
    int addStu(Student student);

    //学生信息的删除
    int delStu(Integer stuNo);

    //根据学号查学生
    Student selectOneStudentByStuNo(Integer stuNo);

    //真正的修改学生方法
    int updateStu(Student student);
}
