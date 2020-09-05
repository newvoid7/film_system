package edu.seu.film_system.mapper;

import edu.seu.film_system.pojo.Record;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RecordMapper {
    @Select("SELECT * FROM record")
    List<Record> findAllRecord();

    @Select("SELECT * FROM record WHERE user_id = ${userId}")
    List<Record> findRecordByUserId(@Param("userId") int userId);

    @Select("SELECT * FROM record WHERE film_id = ${filmId}")
    List<Record> findRecordByFilmId(@Param("filmId") int filmId);

    @Select("SELECT * FROM record WHERE user_id = ${userId} AND film_id = ${filmId}")
    List<Record> findRecordByUserAndFilm(@Param("userId")int userId, @Param("filmId") int filmId);

    // INSERT
    int addRecord(Record record);

    // UPDATE
    int updateRecord(Record record);

    // SELECT
    Record findRecordByRecord(Record record);
}
