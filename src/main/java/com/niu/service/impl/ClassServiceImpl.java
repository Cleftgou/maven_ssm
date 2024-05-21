package com.niu.service.impl;

import com.niu.mapper.ClassMapper;
import com.niu.pojo.Class;
import com.niu.service.ClassService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bairimengchang
 * @version 1.0
 * @project maven_ssm
 * @description
 * @date 2024/4/9 14:36:11
 */
@Service("cs")
public class ClassServiceImpl implements ClassService {

    @Resource
    private ClassMapper classMapper;

    @Override
    public List<Class> getAllCla() {
        return classMapper.selectAll();
    }
}
