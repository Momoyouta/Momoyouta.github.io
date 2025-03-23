package com.momoyouta.web_ani_server.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.momoyouta.web_ani_pojo.VO.WeekListVO;
import com.momoyouta.web_ani_pojo.entity.Animation;
import com.momoyouta.web_ani_pojo.entity.AnimeInfo;
import com.momoyouta.web_ani_pojo.entity.WeekListItem;
import com.momoyouta.web_ani_server.mapper.AnimeInfoMapper;
import com.momoyouta.web_ani_server.mapper.WeekListMapper;
import com.momoyouta.web_ani_server.service.AniService;
import com.momoyouta.web_ani_server.service.WeekListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class WeekListServiceImpl implements WeekListService {

    @Autowired
    private WeekListMapper weekListMapper;

    @Autowired
    private AnimeInfoMapper infoMapper;

    @Autowired
    private AniService aniService;

    @Override
    public List<Long> getDayAnis(int day) {
        List<Long> aniList=weekListMapper.getAniId(day);
        return aniList;
    }


    @Override
    public void updateDayList(List<WeekListItem> dayList, int day) {
        weekListMapper.delByDay(day);
        weekListMapper.insert(dayList);
    }

    @Override
    public List<List<Animation>> getQuarterAnime(String quarter) {
        LambdaQueryWrapper <AnimeInfo> qw=new LambdaQueryWrapper<>();
        qw.select(AnimeInfo::getAnimeId,AnimeInfo::getWeekday).like(AnimeInfo::getStartDate,quarter);
        List<AnimeInfo> animes=infoMapper.selectList(qw);
        List<List<Long>> ids=new ArrayList<>();
        List<List<Animation>>  weeklist=new ArrayList<>();
        for(int i=0;i<8;i++){
            ids.add(new ArrayList<>());
            weeklist.add(new ArrayList<>());
        }
        for(AnimeInfo ani:animes){
            ids.get(Integer.valueOf(ani.getWeekday())).add(ani.getAnimeId());
        }
        log.info("周表动漫id："+ids.toString());
        int day=0;
        for(List<Long> idDay : ids){
            for(Long id :idDay){
                Animation animation=aniService.getById(id);
                animation.setDescription("");
                weeklist.get(day).add(animation);
            }
            day++;
            if(day>7) break;
        }
        log.info(weeklist.toString());
        return weeklist;
    }
}
