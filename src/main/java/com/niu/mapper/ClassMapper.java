package com.niu.mapper;

import com.niu.pojo.Class;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author bairimengchang
 * @version 1.0
 * @project maven_ssm
 * @description
 * @date 2024/4/9 14:18:40
 */
@Repository
public interface ClassMapper {
    //全查
    List<Class> selectAll();

    //增
    int insert(Class c);

    //删
    int deleteById(Integer cid);

    //改
    int update(Class c);

    //单查
    Class selectById(Integer id);

    //多条件查询
    List<Class> selectMsg(@Param("cname") String cname, @Param("ccontent") String ccontent);
}
