package com.momoyouta.web_ani_pojo.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimeKeywordSearchVO implements Serializable {
    private Long animeId;
    private String image;
    private String description;
    private Integer ep;
    private String name;
    private String date;
    private List<String> tags;
    private String company;
}
