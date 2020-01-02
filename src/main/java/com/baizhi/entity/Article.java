package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/*
*文章表
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    private String id;
    private String title;   //标题
    private String author;  //作者
    private String content; //文章内容
    private String guru_id; //上师id
    private Date create_date;   //发表时间
    private String status;     //状态
    private String other;       //其它 预留字段
}
