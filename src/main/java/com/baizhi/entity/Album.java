package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/*
* 专辑表
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album implements Serializable {
    private String id;
    private String title; //标题
    private String img;     //图片
    private String score;      //星级分数
    private String author;      //作者
    private String broadcaster; //播音员
    private String count;       //集数
    private String brief;       //简介
    private Date create_date;   //上传时间
    private String status;      //状态
    private String other;       //其它 预留字段
}
