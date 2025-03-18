package com.momoyouta.web_ani_server.service.impl;
import com.momoyouta.web_ani_pojo.entity.WeekListItem;
import com.momoyouta.web_ani_server.mapper.WeekListMapper;
import com.momoyouta.web_ani_server.service.WeekListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class WeekListServiceImpl implements WeekListService {

    @Autowired
    private WeekListMapper weekListMapper;

    @Override
    public List<Integer> getDayAnis(int day) {
        List<Integer> aniList=weekListMapper.getAniId(day);
        return aniList;
    }


    @Override
    public void updateDayList(List<WeekListItem> dayList, int day) {
        weekListMapper.delByDay(day);
        weekListMapper.insert(dayList);
    }
}
