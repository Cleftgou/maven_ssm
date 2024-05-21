package com.niu.service;

import com.niu.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author bairimengchang
 * @version 1.0
 * @project maven_ssm
 * @description
 * @date 2024/4/9 14:31:59
 */
public interface UserService {

    //登录
    Boolean login(String uname, String upwd);
}
