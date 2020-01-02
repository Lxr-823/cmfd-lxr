package com.baizhi.dao;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDao {
    //展示所有
    public List<Album> queryAll(@Param("start") Integer start,@Param("rows")Integer rows);
    //总条数
    public Integer selectCount();

    //根据id查询一条
    public Album selectById(String id);
}
