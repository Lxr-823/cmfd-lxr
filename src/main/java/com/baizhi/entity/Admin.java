package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/*
* 管理员表
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements Serializable {
    @Excel(name = "编号")
    private String id;
    @Excel(name="用户账号")
    private String username;    //账号
    @Excel(name="用户密码")
    private String password;    //密码
}
