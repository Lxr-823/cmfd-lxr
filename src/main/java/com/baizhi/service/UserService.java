package com.baizhi.service;

import com.baizhi.Vo.UserVo;

import java.util.List;

public interface UserService {
    //鸡图
    public List<UserVo> selectAll();
    //1-12月 访问量图
    public List<UserVo> selectMonth();
    //查询 1-7天
    public List<Integer> selectday(Integer day);
    //删除
    public void deleteById(String id);
}

