package com.baizhi.dao;

import com.baizhi.Vo.UserVo;
import com.baizhi.entity.TUser;

import java.util.List;

public interface T_userDao {
    //查询
    public List<TUser> queryAll();

    //  查询地址/人数
    public List<UserVo>  selectAll();

    //查询1-12个月的每个月的访问量
    public List<UserVo> selectMonth();

    //查询 1-7天
    public Integer selectday(Integer day);


    //根据ID查询
    public TUser selectById(String id);

    //根据id删除
    public void delete(String id);
}
