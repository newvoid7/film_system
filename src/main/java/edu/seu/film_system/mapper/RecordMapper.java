package edu.seu.film_system.mapper;

import edu.seu.film_system.pojo.Record;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RecordMapper {
    @Select("SELECT * FROM record")
    List<Record> findAllRecord();

    @Select("SELECT * FROM record WHERE user_id = ${userId}")
    List<Record> findRecordByUserId(int userId);

    @Select("SELECT * FROM record WHERE film_id = ${filmId}")
    List<Record> findRecordByFilmId(int filmId);

    // INSERT
    int addRecord(Record record);

    // UPDATE
    int updateRecord(Record record);
}
