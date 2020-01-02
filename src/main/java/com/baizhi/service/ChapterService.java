package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.Map;

public interface ChapterService {
    //分页
    public Map<String,Object> queryAll(String id,Integer rows, Integer page);
    //添加
    public void addChapter(Chapter chapter);
    //删除
    public void deleteChapter(String[] id);
    //修改
    public void updateChapter(Chapter chapter);
    //查询
    public Chapter selectById(String id);
    //下载
    /*public String  download(String id, HttpServletResponse response);*/
}
