package com.baizhi.controller;

import com.baizhi.Vo.Header;
import com.baizhi.dao.*;
import com.baizhi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InterfaceController {
    @Autowired
    private BannerDao bannerDao;
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private T_userDao tUserDao;
    @Autowired
    private GuruDao guruDao;
    @Autowired
    private ArticleDao articleDao;

    @RequestMapping("/first_page")
    public Map<String,List<Header>> firstPage(String uid, String type, String sub_type){
       Map<String,List<Header>> map = new HashMap<>();
       List<Header> list = new ArrayList<>();
        if (uid!=null){
            // uid  必填
            if ("all".equals(type)){
                //all 首页
                List<Banner> banners = bannerDao.queryAll(0, 5);
                for (Banner banner : banners) {
                    Header header = new Header();
                    header.setThumbnail(banner.getImg());
                    header.setTitle(banner.getTitle());
                    header.setId(banner.getId());
                    list.add(header);
                    map.put("header",list);
                }

            }else if ("wen".equals(type)){
                // wen  专辑
                List<Album> albums = albumDao.queryAll(0, 5);
                for (Album album : albums) {
                    Header header = new Header();
                    header.setThumbnail(album.getImg());
                    header.setTitle(album.getTitle());
                    header.setAuthor(album.getAuthor());
                    header.setCreate_date(album.getCreate_date());
                    header.setType("0");
                    if (header.getType().equals("0")){
                        String count = album.getCount();
                        header.setSet_count(Integer.valueOf(count));
                    }else {
                        list.add(header);
                        map.put("album",list);
                    }
                    list.add(header);
                    map.put("album",list);
                }

            }else if ("si".equals(type)){
                // si  文章
                if ("ssyj".equals(sub_type)){
                    //上师言教
                    TUser tUser = tUserDao.selectById(uid);
                    Guru guru = guruDao.selectById(tUser.getGuru_Id());
                    List<Article> articles = articleDao.selectByGuruId(guru.getId());
                    for (Article article : articles) {
                        Header header = new Header();
                        header.setThumbnail(article.getContent());
                        header.setTitle(article.getTitle());
                        header.setAuthor(article.getAuthor());
                        header.setType("1");
                        if (header.getType().equals("1")){
                            list.add(header);
                            map.put("artical",list);
                        }else {
                            header.setSet_count(articles.size());
                            list.add(header);
                            map.put("artical",list);
                        }
                        list.add(header);
                        map.put("artical",list);
                    }
                }else if ("xmfy".equals(sub_type)){
                    // 显密法要
                    List<Article> articles = articleDao.queryAll(0, 5);
                    for (Article article : articles) {
                        Header header = new Header();
                        header.setThumbnail(article.getContent());
                        header.setTitle(article.getTitle());
                        header.setAuthor(article.getAuthor());
                        header.setType("1");
                        header.setCreate_date(article.getCreate_date());
                        list.add(header);
                        map.put("artical",list);
                    }
                }
            }
        }
        return map;
    }
}
