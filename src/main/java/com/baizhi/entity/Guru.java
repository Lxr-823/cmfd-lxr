package com.baizhi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
/*
*   上师表
* */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guru implements Serializable {

  private String id;
  private String headImg; //上师头像
  private String name;  //姓名
  private String dharma;  //法号
  private String sex; //性别
  private Date createDate;  //上传时间
  private String status;  //状态
  private String other; //其它 预留字段




}
