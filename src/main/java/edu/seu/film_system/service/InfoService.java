package edu.seu.film_system.service;

import edu.seu.film_system.pojo.Info;
import edu.seu.film_system.pojo.ResultDTO;

import java.util.List;

public interface InfoService {
    List<Info> findAllInfo();
    // 使用 DTO
    ResultDTO<Info> findAllInfo2();
    // 根据关键字查询
    ResultDTO<Info> findInfoByKeyWord(String keyWord);
    //
    ResultDTO<Info> findInfoByInfo(Info info);
    //
    ResultDTO<Info> addInfo(Info info);
}
