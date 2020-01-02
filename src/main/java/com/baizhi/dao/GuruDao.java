package com.baizhi.dao;

import com.baizhi.entity.Guru;

public interface GuruDao {
    //身居上师id查找头像
    public Guru selectById(String id);
}
