package edu.seu.film_system.service;

import edu.seu.film_system.pojo.Info;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface InfoService {
    @Select("SELECT * FROM info")
    List<Info> findAllInfo();
}
