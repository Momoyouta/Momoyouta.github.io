package com.momoyouta.web_ani_server.service;

import com.momoyouta.web_ani_common.result.Result;
import com.momoyouta.web_ani_pojo.dto.AniAddDTO;
import com.momoyouta.web_ani_pojo.entity.Animation;

import java.util.List;

public interface AniService {
    public Animation getById(Integer id);

    public Result update(Animation animation);

    Result add(AniAddDTO aniAddDTO);

    void deleteByName(String name);

    List<Animation> getByNamelike(String name,int page,int pageSize);

    Animation getByName(String name);

    Integer getByNamelikeTotPage(String name);

}
