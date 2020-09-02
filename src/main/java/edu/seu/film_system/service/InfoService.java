package edu.seu.film_system.service;

import edu.seu.film_system.pojo.Info;
import edu.seu.film_system.pojo.ResultDTO;

import java.util.List;

public interface InfoService {
    List<Info> findAllInfo();
    ResultDTO<Info> findAllInfo2();
}
