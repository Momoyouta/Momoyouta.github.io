package com.momoyouta.web_ani_server.controller.admin;

import com.momoyouta.web_ani_common.result.Result;
import com.momoyouta.web_ani_pojo.entity.Animation;
import com.momoyouta.web_ani_pojo.entity.WeekListItem;
import com.momoyouta.web_ani_server.service.AniService;
import com.momoyouta.web_ani_server.service.WeekListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController("adminWeekListController")
@RequestMapping("/admin/weeklist")
public class WeekListController {

    @Autowired
    private WeekListService weekListService;

    @Autowired
    private AniService aniService;

    @GetMapping("/request")
    public Result<List<Animation>> getDaylist(@RequestParam Integer day){
        log.info(day.toString());
        List<Long> idList=weekListService.getDayAnis(day);
        log.info(idList.toString());
        List<Animation> aniList=new ArrayList<>();
        for(Long id : idList){
            Animation animation=aniService.getById(id);
            animation.setDescription("");
            aniList.add(animation);
        }
        log.info(aniList.toString());
        return Result.success(aniList);
    }

    @PutMapping("/update/{day}")
    public Result<String> updateList(@RequestBody  List<WeekListItem>  dayList, @PathVariable int day){
        log.info(dayList.toString());
        weekListService.updateDayList(dayList,day);
        return Result.success("更新成功");
    }

    @GetMapping ("/request/quarter")
    public Result<List<List<Animation>>> getQuarterlist(@RequestParam String quarter){
        log.info(quarter);
        List<List<Animation>> list= weekListService.getQuarterAnime(quarter);
        return Result.success(list);
    }

}
