package com.baizhi;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = CmfdLxrApplication.class)
@RunWith(SpringRunner.class)
public class ArticleTest {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private ArticleService articleService;

    @Test
    public void test1(){
        List<Article> articles = articleDao.queryAll(0, 1);
        for (Article article : articles) {
            System.out.println(article);
        }
    }
    @Test
    public void test2(){
        String[]  s={"1","2"};
        articleService.deleteById(s);
    }
}
