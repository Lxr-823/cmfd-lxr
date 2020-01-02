package com.baizhi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/*
* 功课表
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Serializable {

  private String id;
  private String title; //标题
  private String levels;  //级别
  private String userId;  //用户id
  private Date createDate;  //创建时间
  private String status;  //状态
  private String other; //其它 预留字段

}
