package edu.seu.film_system.mapper;

import edu.seu.film_system.pojo.Record;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RecordMapper {
    @Select("SELECT * FROM record")
    List<Record> findAllRecord();

    // TODO
    // @Select("SELECT * FROM record WHERE user_id")
}
