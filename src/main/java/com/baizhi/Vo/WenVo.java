package com.baizhi.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class WenVo {
    private String thumbnail;//缩略图
    private String title;//专辑名
    private String score;//分数
    private String author;//作者
    private String broadcast;//播音
    private String set_count;//集数
    private String brief;//内容简介
    private Date create_date;//发布日期
    private String download_url;//下载地址
    private String size;//音频大小
    private String  duration;//音频时长
}
