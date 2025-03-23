package com.momoyouta.web_ani_pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("animeatags")
public class AnimeAtags implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long tagId;
    private Long animeId;
}
