package com.momoyouta.web_ani_server.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.momoyouta.web_ani_pojo.entity.AnimeAtags;
import com.momoyouta.web_ani_pojo.entity.Tag;
import com.momoyouta.web_ani_server.mapper.AnimeAndTagsMapper;
import com.momoyouta.web_ani_server.mapper.TagMapper;
import com.momoyouta.web_ani_server.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;
    @Autowired
    AnimeAndTagsMapper animeAndTagsMapper;

    @Override
    public Tag getTagByName(String name) {
        LambdaQueryWrapper<Tag> qw=new LambdaQueryWrapper<>();
        qw.eq(Tag::getName,name);
        Tag tag=tagMapper.selectOne(qw);
        return tag;
    }

    @Override
    public void addTag(Tag tag) {
        if(getTagByName(tag.getName())==null){
            tagMapper.insert(tag);
        }
    }



    @Override
    public void addTags(List<Tag> tags) {
        for(Tag tag:tags){
            Tag tp=getTagByName(tag.getName());
            if(tp==null){
                tagMapper.insert(tag);
            }else{
                tp.setCount(tp.getCount()+1);
                LambdaUpdateWrapper<Tag> uw=new LambdaUpdateWrapper<>();
                uw.eq(Tag::getId,tp.getId());
                tagMapper.update(tag,uw);
            }
        }
    }

    @Override
    public List<String> getAnimeTags(Long animeId) {
        LambdaQueryWrapper < AnimeAtags> qwIds=new LambdaQueryWrapper<>();
        qwIds.select(AnimeAtags::getTagId).eq(AnimeAtags::getAnimeId,animeId);
        List<AnimeAtags> tags=animeAndTagsMapper.selectList(qwIds);
        List<Long> tagIds=tags.stream().map(tag -> Long.valueOf(tag.getTagId())).collect(Collectors.toList());
        LambdaQueryWrapper <Tag> qwName=new LambdaQueryWrapper<>();
        qwName.select(Tag::getName).in(Tag::getId,tagIds);
        List<Tag> tags2=tagMapper.selectList(qwName);
        List<String> list = tags2.stream()
                .map(Tag::getName)
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public void updateCount() {
        LambdaQueryWrapper<Tag> qw=new LambdaQueryWrapper<>();
        LambdaQueryWrapper<AnimeAtags> at=new LambdaQueryWrapper<>();
        qw.like(Tag::getName,"");
        List<Tag> list=tagMapper.selectList(qw);
        for(Tag tag:list){
            at.clear();
            at.eq(AnimeAtags::getTagId,tag.getId());
            Long count=animeAndTagsMapper.selectCount(at);
            tag.setCount(count);
            log.info(tag.getName()+"共"+count+"个");
            LambdaUpdateWrapper <Tag> up=new LambdaUpdateWrapper<>();
            up.eq(Tag::getId,tag.getId());
            tagMapper.update(tag,up);
        }

    }

    @Override
    public List<Tag> getHotTag() {
        List<Tag> list = new ArrayList<>();
        LambdaQueryWrapper<Tag> qw=new LambdaQueryWrapper<>();
        qw.orderByDesc(Tag::getCount).last("limit 40");
        List<String> excludedWords = Arrays.asList("TV", "日本", "漫画改", "漫改", "TVA", "动画", "续作", "日漫", "未确定");
        list=tagMapper.selectList(qw).stream().filter((tag)->
            !excludedWords.contains(tag.getName())
        ).collect(Collectors.toList());
        return list;
    }
}
