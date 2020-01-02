package com.baizhi;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = CmfdLxrApplication.class)
@RunWith(SpringRunner.class)
public class BannerTest {
    @Autowired
    private BannerDao bannerDao;
@Autowired
private BannerService bannerService;
    @Test
    public void test1(){
        List<Banner> banners = bannerDao.queryAll(0, 1);
        for (Banner banner : banners) {
            System.out.println(banner);
        }
    }
    @Test
    public void test2(){
        bannerDao.addBanner(new Banner("3","轮播图3","dsadasdsa",new Date(),"激活",""));
    }
    @Test
    public void test3(){
        bannerDao.updateBanner(new Banner("3","轮播图3","3333",new Date(),"激活",""));
    }
    @Test
    public void test4(){
        Map<String, Object> map = bannerService.queryAll(1, 1);
        for (String s : map.keySet()) {
            System.out.println(map.get(s));

        }
    }
    @Test
    public void test5(){

    }

}
