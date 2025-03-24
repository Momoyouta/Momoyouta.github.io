package com.momoyouta.web_ani_server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.momoyouta.web_ani_pojo.entity.AnimeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AnimeInfoMapper extends BaseMapper<AnimeInfo> {

    @Select("select * from momoyouta_web_ani.animeinfo_list where anime_id=#{animeId}")
    public AnimeInfo getAnimeId(Long animeId);
}
