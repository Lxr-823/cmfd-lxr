package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/*
*  章节表
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter implements Serializable {
    private String id;
    private String title;   //标题
    private String album_id;    //专辑id
    private String size;    //大小
    private String duration;    //时长
    private String src;     //路径
    private String status;  //状态
    private String other;   //其它 预留字段
}
