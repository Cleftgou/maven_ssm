package com.niu.service.impl;

import com.niu.mapper.StudentMapper;
import com.niu.pojo.Student;
import com.niu.service.StudentService;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author bairimengchang
 * @version 1.0
 * @project maven_ssm
 * @description
 * @date 2024/4/9 14:36:41
 */
@Service("ss")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getAllStu() {
        List<Student> students = studentMapper.selectAll();
        return students;
    }

    @Override
    public boolean delStu(int stuNo) {
        int i = studentMapper.delStu(stuNo);
        return i > 0;
    }

    @Override
    public Student editStu(Integer stuNo) {
        return studentMapper.selectOneStudentByStuNo(stuNo);
    }

    @Override
    public boolean addStu(Student stu) {
        int i = studentMapper.addStu(stu);
        return i > 0;
    }


}
