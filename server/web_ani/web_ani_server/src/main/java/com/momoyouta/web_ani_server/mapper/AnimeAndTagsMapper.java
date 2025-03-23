package com.momoyouta.web_ani_server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.momoyouta.web_ani_pojo.entity.AnimeAtags;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnimeAndTagsMapper extends BaseMapper<AnimeAtags> {
}
