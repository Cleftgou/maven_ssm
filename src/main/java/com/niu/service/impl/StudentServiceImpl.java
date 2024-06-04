package com.niu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niu.mapper.StudentMapper;
import com.niu.pojo.Student;
import com.niu.service.StudentService;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String,Object> map = new HashMap<>();
        List<Student> students = studentMapper.selectAll(map);
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
    public boolean updateStu(Student stu) {
        //修改成功返回true
        return studentMapper.updateStu(stu) == 1;
    }

    @Override
    public boolean addStu(Student stu) {
        int i = studentMapper.addStu(stu);
        return i > 0;
    }

    @Override
    public PageInfo<Student> getStuByPage(int pageNow, int pageSize, Map<String,Object> map) {
        //开启分页插件
        PageHelper.startPage(pageNow, pageSize, "stuNo desc");
        //调用全查功能，会自动分页
        List<Student> students = studentMapper.selectAll(map);
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return pageInfo;
    }


}
