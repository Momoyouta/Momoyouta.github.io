package com.momoyouta.web_ani_pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("animerating")
public class AnimeRating implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long animeId;
    @TableField("`rank`")
    private int rank;
    private Long scoreTotal;
    private BigDecimal score;
    private Long collect;
    private Long doing;
    private Long views;
}

