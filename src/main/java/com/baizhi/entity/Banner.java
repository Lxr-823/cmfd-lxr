package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
/*
* 轮播图
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banner implements Serializable {
private  String id;
private String title;   //标题
private String img;     //图片
private Date create_date;   //创建日期
private String status;      //状态
private String other;          //其它  预留字段
}
