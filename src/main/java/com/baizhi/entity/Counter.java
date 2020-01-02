package com.baizhi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
/*
* 计数器表
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Counter implements Serializable {
  private String id;
  private String title; //标题
  private String count; //  计数
  private Date lastDate;//最后更新时间
  private String userId;  //用户id
  private String taskId;  //功课id
  private String status;  //状态
  private String other; //其它 预留字段



}
