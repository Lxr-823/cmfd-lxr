package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.Map;

public interface BannerService {
//分页
    public Map<String,Object> queryAll(Integer rows, Integer page);
    //添加
    public void addBanner(Banner banner);
    //修改
    public void updateBanner(Banner banner);
    //删除
    public void deleteBanner(String[] ids);

}
