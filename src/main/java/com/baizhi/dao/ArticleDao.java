package com.baizhi.dao;

import com.baizhi.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {
    //分页
    public List<Article> queryAll(@Param("start")Integer start,@Param("rows")Integer rows);
    //总条数
    public Integer count();
    //删除
    public void delete(String[] id);
    //添加
    public void addArticle(Article article);
    //修改
    public void updateArticle(Article article);
    //展示
    public Article selectById(String id);

    //根据上师id查询文章
    public List<Article> selectByGuruId(String id);
}
