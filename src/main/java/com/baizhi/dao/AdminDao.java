package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
    //根据用户name/password查找用户
    public Admin queryByname(@Param("username") String username);
    //查找
    public List<Admin> queryAdmin();

    //查询总人数
    public Integer selecyCount();
}
