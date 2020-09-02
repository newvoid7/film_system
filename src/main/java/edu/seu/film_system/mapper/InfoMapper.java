package edu.seu.film_system.mapper;

import edu.seu.film_system.pojo.Info;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InfoMapper {
    @Select("SELECT * FROM info")
    List<Info> findAllInfo();

    @Select("SELECT * FROM info WHERE name LIKE '%${value}%' OR id LIKE '%${value}%'")
    List<Info> findInfoByKeyWord(String keyWord);
}
