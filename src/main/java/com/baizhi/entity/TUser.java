package com.baizhi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/*
*   用户表
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TUser implements Serializable {

  private String id;
  private String phone_Number; //手机号
  private String password;  //密码
  private String name;  //姓名
  private String dharma;
  private String head_Img;
  private String sex;
  private String address;
  private String sign;
  private String guru_Id;
  private java.util.Date last_Date;
  private java.util.Date create_Date;
  private String status;
  private String salt;
  private String other;

}
