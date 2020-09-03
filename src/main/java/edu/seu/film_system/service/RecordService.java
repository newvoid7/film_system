package edu.seu.film_system.service;

import edu.seu.film_system.pojo.Record;
import edu.seu.film_system.pojo.ResultDTO;

public interface RecordService {
    ResultDTO<Record> findAllRecord();
    ResultDTO<Record> findRecordByUserId(int userId);
    ResultDTO<Record> findRecordByFilmId(int filmId);
}
