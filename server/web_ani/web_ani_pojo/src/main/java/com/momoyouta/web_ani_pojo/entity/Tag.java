package com.momoyouta.web_ani_pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tags")
public class Tag implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Long count;
}
