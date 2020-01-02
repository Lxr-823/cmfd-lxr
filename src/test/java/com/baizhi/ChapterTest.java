package com.baizhi;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmfdLxrApplication.class)
public class ChapterTest {
    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private ChapterService chapterService;

    @Test
    public void test1() {
        List<Chapter> chapters = chapterDao.queryAll("1", 0, 2);
        System.out.println(chapters);
    }

    @Test
    public void test2() {
        Map<String, Object> map = chapterService.queryAll("1", 2, 1);
        for (String s : map.keySet()) {
            System.out.println(s);
        }
    }

    @Test
    public void test3() {
        chapterDao.addChapter(new Chapter("7", "dadsa", "3", "10", "dsadas", "dsadas", "dasdasdas", "dasdas"));
    }
    @Test
    public void test4(){
        Chapter chapter = chapterDao.selectById("cc6b741b-6552-41ee-8b89-111523bef63b");
        System.out.println(chapter);
    }
}