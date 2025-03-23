package com.momoyouta.web_ani_pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Animation implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String image;
    private String description;
    private LocalDateTime updateTime;
    private Integer score;
    private Integer ban;
    private Integer ep;
    private Integer end;
    //private int type;
}
