package com.baizhi.serviceImpl;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("BannerService")
@Transactional

public class BannerServiceImpl  implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    //分页
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Map<String, Object> queryAll(Integer rows, Integer page) {
        Integer start = (page-1)* rows;
        List<Banner> banners = bannerDao.queryAll(start, rows);
        //总条数
        Integer count = bannerDao.count();
        Integer tatolPage = count%rows==0 ? count/rows : count/rows+1;
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("rows",banners);
        map.put("total",tatolPage);
        map.put("records",count);
        return map;
    }
    //添加
    @Override
    public void addBanner(Banner banner) {

        bannerDao.addBanner(banner);
    }
    //修改
    @Override
    public void updateBanner(Banner banner) {
        bannerDao.updateBanner(banner);
    }
    //删除
    @Override
    public void deleteBanner(String[] ids) {
        bannerDao.deleteBanner(ids);
    }


}
