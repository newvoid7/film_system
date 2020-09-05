package edu.seu.film_system.service;

import edu.seu.film_system.pojo.Record;
import edu.seu.film_system.pojo.ResultDTO;

public interface RecordService {
    ResultDTO<Record> findAllRecord();
    ResultDTO<Record> findRecordByUserId(int userId);
    ResultDTO<Record> findRecordByFilmId(int filmId);
    boolean findRecordByUserAndFilm(int userId, int filmId);
    ResultDTO<Record> addRecord(Record record);
    ResultDTO<Record> updateRecord(Record record);
    ResultDTO<Record> findRecordByRecord(Record record);
}
