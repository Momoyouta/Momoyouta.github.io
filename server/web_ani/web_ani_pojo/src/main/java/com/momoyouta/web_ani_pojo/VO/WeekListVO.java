package com.momoyouta.web_ani_pojo.VO;

import com.momoyouta.web_ani_pojo.entity.Animation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeekListVO implements Serializable {
    private Animation animation;
    private int day;
}
