package com.baizhi.serviceImpl;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDao chapterDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Map<String, Object> queryAll(String id, Integer rows, Integer page) {
        Map<String, Object> map = new HashMap<>();
        Integer start = (page - 1) * rows;
        List<Chapter> chapters = chapterDao.queryAll(id, start, rows);
        //总条数
        Integer count = chapterDao.selectCount(id);
        Integer tatolPage = count % rows == 0 ? count / rows : count / rows + 1;
        map.put("page", page);
        map.put("rows", chapters);
        map.put("total", tatolPage);
        map.put("records", count);
        return map;
    }

    //添加
    @Override
    public void addChapter(Chapter chapter) {
        chapterDao.addChapter(chapter);
    }

    //删除
    @Override
    public void deleteChapter(String[] id) {
        chapterDao.deleteChapter(id);

    }

    //修改
    @Override
    public void updateChapter(Chapter chapter) {
        chapterDao.updateChapter(chapter);
    }

    @Override
    public Chapter selectById(String id) {
        Chapter chapter = chapterDao.selectById(id);
        return chapter;
    }

}