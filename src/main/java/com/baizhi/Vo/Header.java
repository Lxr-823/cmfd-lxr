package com.baizhi.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Header implements Serializable {
    private String thumbnail; //图片
    private String desc;    //头图描述
    private String id;  //头图id
    private String title;   //标题
    private String  author;//描述
    private String type;//类型
    private Integer set_count;//集数
    private Date create_date;//创建时间
}
