package com.momoyouta.web_ani_pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AniAddDTO  implements Serializable {
    private Integer id;
    private String name;
    private String videoAddr;
    private String image;
    private String description;
    private String cvList;
    private Integer ed;
    private Integer end;
}
