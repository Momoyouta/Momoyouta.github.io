package com.momoyouta.web_ani_pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirCondition implements Serializable {
   private String tag;
   private String year;
    private  int order;
    private int offset;
    private int pageSize;
    private Long tagId;
}
