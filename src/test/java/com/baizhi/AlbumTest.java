package com.baizhi;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@SpringBootTest(classes = CmfdLxrApplication.class)
@RunWith(SpringRunner.class)
public class  AlbumTest {
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private AlbumService     albumService;

    @Test
    public void test1(){
        List<Album> albums = albumDao.queryAll(1,1);
        for (Album album : albums) {
            System.out.println(album);
        }
        }
    @Test
    public void test2() {
        Integer count = albumDao.selectCount();
        System.out.println(count);
    }
    @Test
    public void test3(){
        Map<String, Object> map = albumService.queryAll(1, 1);
        System.out.println(map);
    }

    @Test
    public void test4(){
        Album album = albumDao.selectById("1");
        System.out.println(album);
    }
}
