package com.momoyouta.web_ani_server.controller.admin;

import com.momoyouta.web_ani_common.result.Result;
import com.momoyouta.web_ani_pojo.dto.BangumiBaseAnimeDTO;
import com.momoyouta.web_ani_pojo.entity.Animation;
import com.momoyouta.web_ani_server.service.AniService;
import com.momoyouta.web_ani_server.service.BangumiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/admin/bangumi")
public class BangumiController {

    @Autowired
    private BangumiService bangumiService;

    @PutMapping("/baseadd")
    public Result<Integer> getbaseAnimes(@RequestBody BangumiBaseAnimeDTO baseAnimeDTO){
        log.info(baseAnimeDTO.toString());
        int p=bangumiService.transAnimeData(baseAnimeDTO);
        return Result.success(p);
    }


}
