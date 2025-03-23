package com.momoyouta.web_ani_server.service.impl;

import com.momoyouta.web_ani_common.result.Result;
import com.momoyouta.web_ani_pojo.dto.BangumiBaseAnimeDTO;
import com.momoyouta.web_ani_pojo.entity.Animation;
import com.momoyouta.web_ani_pojo.entity.AnimeInfo;
import com.momoyouta.web_ani_pojo.entity.AnimeRating;
import com.momoyouta.web_ani_pojo.entity.Tag;
import com.momoyouta.web_ani_server.service.AniService;
import com.momoyouta.web_ani_server.service.BangumiService;
import com.momoyouta.web_ani_server.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BangumiServiceImpl implements BangumiService {

    @Autowired
    private AniService aniService;
    @Autowired
    private TagService tagService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int transAnimeData(BangumiBaseAnimeDTO baseAnimeDTO) {
        Animation animation=new Animation();
        BeanUtils.copyProperties(baseAnimeDTO.getAnimation(),animation);
        AnimeInfo animeInfo=new AnimeInfo();
        BeanUtils.copyProperties(baseAnimeDTO.getAnimeInfo(),animeInfo);
        AnimeRating animeRating=new AnimeRating();
        BeanUtils.copyProperties(baseAnimeDTO.getAnimeRating(),animeRating);
        if(aniService.getByName(animation.getName())!=null) return 1;
        try {
            aniService.addNoDTO(animation);
            Long animeId = animation.getId();
            animeRating.setAnimeId(animeId);
            animeInfo.setAnimeId(animeId);
            List<String> tags = baseAnimeDTO.getTags();
            List<Tag> tagList=new ArrayList<>();
            Long zero = Long.valueOf(0);
            for(String tp:tags){;
                Tag t=new Tag(null,tp,zero);
                tagList.add(t);
            }
            tagService.addTags(tagList);
            aniService.addAnimeInfo(animeInfo);
            aniService.addAnimeRating(animeRating);
            aniService.addTag(animeId,tags);
            log.info("anime_id:" + animation.getId());
            log.info("info_id:" + animeInfo.getId());
            log.info("rating_id:" + animeRating.getId());
        }
        catch (Exception e){
            System.out.println(e);
            return 0;
        }
        return 1;
    }
}
