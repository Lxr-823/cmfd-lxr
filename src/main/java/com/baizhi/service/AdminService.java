package com.baizhi.service;

import com.baizhi.entity.Admin;

import java.util.List;

public interface AdminService {
//查找用户
    public Admin queryByname(String username);

    //查找
    public List<Admin> queryAll();
}
