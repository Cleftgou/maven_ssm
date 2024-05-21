package com.niu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author bairimengchang
 * @version 1.0
 * @project maven_ssm
 * @description
 * @date 2024/4/9 14:15:58
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private Integer stuNo;

    private String stuName;

    private Integer stuAge;

    private String stuImg;

    //关联的数据库表
    private Class cla;

}
