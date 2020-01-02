package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/Article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/query")
    @ResponseBody
    public Map<String,Object> queryAll(Integer page,Integer rows){
        Map<String, Object> map = articleService.queryAll(page, rows);
        return  map;
    }

    @ResponseBody
    @RequestMapping("/edit")
    public void edit(String[] id, String oper, Article article){
        if ("del".equals(oper)){
            articleService.deleteById(id);
        }
    }

    //添加
    @ResponseBody
    @RequestMapping("/add")
    public void addArticle(Article article,String text){
        article.setContent(text);
       articleService.addArticle(article);
    }

    //查看
    @ResponseBody
    @RequestMapping("/select")
    public Article selectArticle(String id){
        Article article = articleService.selectById(id);
        return  article;
    }

    //修改
    @ResponseBody
    @RequestMapping("/update")
    public void  updateArticle(Article article){
        System.out.println(article+"!!!!!!!!!!!!!!");
        articleService.updateArticle(article);

    }
    //回显
    @ResponseBody
    @RequestMapping("/selectid")
    public Article selectid(String id){
        Article article1 = articleService.selectById(id);
        return article1;
    }
}
