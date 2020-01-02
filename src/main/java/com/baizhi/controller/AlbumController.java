package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;

@Controller
@RequestMapping("/Album")
public class AlbumController {
@Autowired
    private AlbumService albumService;

    //分页
    @ResponseBody
    @RequestMapping("/queryAll")
    public Map<String,Object> queryAll(Integer rows,Integer page){
        Map<String, Object> map = albumService.queryAll(rows,page);
        return  map;
    }

}
