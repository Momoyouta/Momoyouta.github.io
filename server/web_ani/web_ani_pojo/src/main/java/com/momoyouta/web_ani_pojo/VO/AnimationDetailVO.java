package com.momoyouta.web_ani_pojo.VO;


import com.momoyouta.web_ani_pojo.entity.Animation;
import com.momoyouta.web_ani_pojo.entity.AnimeInfo;
import com.momoyouta.web_ani_pojo.entity.AnimeRating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimationDetailVO {
    private Animation animation;
    private AnimeInfo animeInfo;
    private AnimeRating animeRating;
    private List<String> tags;
}
