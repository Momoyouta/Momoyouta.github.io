package com.momoyouta.web_ani_server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.momoyouta.web_ani_common.result.Result;
import com.momoyouta.web_ani_pojo.dto.AniAddDTO;
import com.momoyouta.web_ani_pojo.entity.Animation;
import com.momoyouta.web_ani_server.mapper.AniMapper;
import com.momoyouta.web_ani_server.service.AniService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
public class AniServiceImpl implements AniService {

    @Autowired
    private AniMapper aniMapper;

    @Override
    public Animation getById(Integer id) {
        return aniMapper.getById(id);
    }

    @Override
    public Result update(Animation animation){
        LambdaUpdateWrapper<Animation> lambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        animation.setUpdateTime(LocalDateTime.now().withNano(0).withSecond(0));
        log.info(aniMapper.update(animation,
                lambdaUpdateWrapper.eq(Animation::getId, animation.getId()))+"");
        return Result.success("更新成功");
    }

    @Override
    public Result add(AniAddDTO aniAddDTO) {
        Animation animation=new Animation();
        BeanUtils.copyProperties(aniAddDTO,animation);
        animation.setUpdateTime(LocalDateTime.now().withNano(0).withSecond(0));
        animation.setBan(1);
        log.info(animation.toString());
        if(aniMapper.getByName(animation.getName())!=null){
            return Result.error("番剧已存在");
        }

        aniMapper.insert(animation);
        return Result.success("添加成功");
    }

    @Override
    public List<Animation> getByNamelike(String name,int page,int pageSize) {
        page=(page-1)*pageSize;
        List<Animation> list=aniMapper.getByNamelike(name,page,pageSize);
        return list;
    }

    @Override
    public Animation getByName(String name){
        return aniMapper.getByName(name);
    }

    @Override
    public Integer getByNamelikeTotPage(String name) {
        int pages=aniMapper.getByNamelikeTotPage(name);
        return pages;
    }

    @Override
    public void deleteByName(String name){

        aniMapper.deleteByName(name);
    }
}
