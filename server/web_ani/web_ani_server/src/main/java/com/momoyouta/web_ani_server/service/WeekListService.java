package com.momoyouta.web_ani_server.service;

import com.momoyouta.web_ani_pojo.entity.Animation;
import com.momoyouta.web_ani_pojo.entity.WeekListItem;

import java.util.List;

public interface WeekListService {
    List<Integer> getDayAnis(int day);

    void updateDayList(List<WeekListItem> dayList,int day);
}
