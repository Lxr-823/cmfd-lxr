package com.baizhi.service;

import com.baizhi.entity.Article;

import java.util.Map;

public interface ArticleService {
    //分页
    public Map<String,Object> queryAll(Integer page,Integer rows);
    //删除
    public void deleteById(String[] id);
    //添加
    public void addArticle(Article article);
    //修改
    public void updateArticle(Article article);
    //展示
    public Article selectById(String id);
}
