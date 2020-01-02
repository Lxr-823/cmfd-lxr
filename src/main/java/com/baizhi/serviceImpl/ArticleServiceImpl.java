package com.baizhi.serviceImpl;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Map<String, Object> queryAll(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        Integer start = (page-1)*rows;
        Integer count = articleDao.count();
        Integer total =count%rows==0 ? count/rows :count/rows+1;
        List<Article> articles = articleDao.queryAll(start, rows);
        map.put("rows",articles);
        map.put("records",count);
        map.put("total",total);
        map.put("page",page);
        return map;
    }
//删除
    @Override
    public void deleteById(String[] id) {
            articleDao.delete(id);
    }
//添加
    @Override
    public void addArticle(Article article) {
        article.setId(UUID.randomUUID().toString());
        article.setGuru_id(UUID.randomUUID().toString());
        article.setCreate_date(new Date());
        articleDao.addArticle(article);
    }
//修改

    @Override
    public void updateArticle(Article article) {
    article.setCreate_date(new Date());
    if ("".equals(article.getContent())){
        article.setContent(null);

    }
        articleDao.updateArticle(article);
    }




//查看详细信息
    @Override
    public Article selectById(String id) {
        Article article = articleDao.selectById(id);
        return article;
    }
}
