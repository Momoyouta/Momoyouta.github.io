package com.momoyouta.web_ani_pojo.dto;

import com.momoyouta.web_ani_pojo.entity.Animation;
import com.momoyouta.web_ani_pojo.entity.AnimeInfo;
import com.momoyouta.web_ani_pojo.entity.AnimeRating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BangumiBaseAnimeDTO implements Serializable {
    private Animation animation;
    private AnimeInfo animeInfo;
    private AnimeRating animeRating;
    private List<String> tags;
}
