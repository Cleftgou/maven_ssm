package com.niu.mapper;

import com.niu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author bairimengchang
 * @version 1.0
 * @project maven_ssm
 * @description
 * @date 2024/4/9 14:18:19
 */
@Repository
public interface UserMapper {
    //全查
    List<User> selectAll();

    //增
    int insert(User user);

    //删
    int deleteById(Integer uid);

    //改
    int update(User user);

    //单查
    User selectById(Integer id);

    //多条件查询（登录）
    User login(@Param("uname") String uname, @Param("upwd") String upwd);
}
