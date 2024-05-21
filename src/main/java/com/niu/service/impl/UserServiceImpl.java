package com.niu.service.impl;

import com.niu.mapper.UserMapper;
import com.niu.pojo.User;
import com.niu.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bairimengchang
 * @version 1.0
 * @project maven_ssm
 * @description
 * @date 2024/4/9 14:35:47
 */
@Service("us")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean login(String uname, String upwd) {
        User login = userMapper.login(uname, upwd);
        if (login != null){
            return true;
        }else {
            return false;
        }
    }
}
