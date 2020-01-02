package com.baizhi.controller;

import com.baizhi.Vo.WenVo;
import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ResponseBody
@RestController
public class DetaiControllerl {
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private ChapterDao chapterDao;

    @RequestMapping("/detai")
    public Map<String, List<WenVo>> detai(String id,String uid){
        Map<String, List<WenVo>> map = new HashMap<>();
        List<WenVo> list = new ArrayList<>();
        Album album = albumDao.selectById(id);
        WenVo wenVo = new WenVo();
        wenVo.setThumbnail(album.getImg());
        wenVo.setTitle(album.getTitle());
        wenVo.setScore(album.getScore());
        wenVo.setBroadcast(album.getBroadcaster());
        wenVo.setSet_count(album.getCount());
        wenVo.setBrief(album.getBrief());
        wenVo.setCreate_date(album.getCreate_date());
        list.add(wenVo);
        map.put("introduction",list);
        return map;
    }
    @RequestMapping("/deta")
    public Map<String, List<WenVo>> deta(String id,String uid){
        List<WenVo> list = new ArrayList<>();
        Map<String,List<WenVo>> map = new HashMap<>();
        List<Chapter> chapters = chapterDao.queryAll(id, 0, 5);
        for (Chapter chapter : chapters) {
            WenVo wenVo = new WenVo();
            wenVo.setTitle(chapter.getTitle());
            wenVo.setDownload_url(chapter.getSrc());
            wenVo.setSize(chapter.getSize());
            wenVo.setDuration(chapter.getDuration());
            list.add(wenVo);
            map.put("list",list);
        }
        return map;
    }
}
