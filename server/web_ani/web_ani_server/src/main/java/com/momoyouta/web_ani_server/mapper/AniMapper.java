package com.momoyouta.web_ani_server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.momoyouta.web_ani_pojo.entity.Animation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AniMapper extends BaseMapper<Animation> {

    @Select("select * from animation where id = #{id}")
    Animation getById(Integer id);

    @Select("select * from animation where name = #{name}")
    Animation getByName(String name);

    @Select("select * from animation where  name like concat('%',#{name},'%') limit #{page},#{pageSize}")
    List<Animation> getByNamelike(String name,int page,int pageSize);

    @Delete("delete from animation where name = #{name}")
    void deleteByName(String name);

    @Select("select count(*) from animation where name like concat('%',#{name},'%')")
    Integer getByNamelikeTotPage(String name);
}
