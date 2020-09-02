package edu.seu.film_system.mapper;

import edu.seu.film_system.pojo.Info;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InfoMapper {
    @Select("SELECT * FROM info")
    List<Info> findAllInfo();

    @Select("SELECT * FROM info WHERE name LIKE '%${value}%' OR id LIKE '%${value}%'")
    List<Info> findInfoByKeyWord(String keyWord);

    // 根据 Info 查询信息
    List<Info> findInfoByInfo(Info info);

    // DML INSERT UPDATE DELETE
    int addInfo(Info info);
}
