package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
* 轮播图
* */
public interface BannerDao {
    //查看所有
    public List<Banner> queryAll(@Param("start") Integer start, @Param("rows") Integer rows);
    //查看总条数
    public Integer count();
    //添加
    public void addBanner(Banner banner);
    //修改
    public void updateBanner(Banner banner);
    //删除
    public void deleteBanner(String[] ids);

}
