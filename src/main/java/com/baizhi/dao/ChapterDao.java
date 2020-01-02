package com.baizhi.dao;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterDao {
    //分页
    public List<Chapter> queryAll(@Param("id") String id,@Param("start") Integer start,@Param("rows") Integer rows);
    //总条数
    public Integer selectCount(String id);
    //添加
    public void addChapter(Chapter chapter);
    //删除
    public void deleteChapter(String[] id);
    //修改
    public void updateChapter(Chapter chapter);
    //根据ID查询
    public Chapter selectById(String id);
}
