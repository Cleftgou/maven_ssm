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
 * @date 2024/4/9 14:14:17
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Class implements Serializable {
    private Integer cid;
    private String cname;
    private String ccontent;
}
