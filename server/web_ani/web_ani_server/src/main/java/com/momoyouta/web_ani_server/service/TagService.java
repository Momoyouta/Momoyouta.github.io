package com.momoyouta.web_ani_server.service;

import com.momoyouta.web_ani_pojo.entity.Tag;

import java.util.List;

public interface TagService {
    public Tag getTagByName(String name);

    public void addTag(Tag tag);

    void addTags(List<Tag> tags);

    List<String> getAnimeTags(Long animeId);

    void updateCount();

    List<Tag> getHotTag();
}
