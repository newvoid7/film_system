package edu.seu.film_system.mapper;

import edu.seu.film_system.pojo.Review;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface ReviewMapper {
    @Select("SELECT * FROM review")
    List<Review> findAllReview();

    @Select("SELECT * FROM review WHERE user_id = ${userId}")
    List<Review> searchByUser(@Param("userId")int userId);

    @Select("SELECT * FROM review WHERE film_id = ${filmId}")
    List<Review> searchByFilm(@Param("filmId")int filmId);

    @Select("SELECT * FROM review WHERE content LIKE '${keyWord}'")
    List<Review> searchByContent(@Param("keyWord") String keyWord);

    @Insert("INSERT INTO review (time, user_id, film_id, content) VALUES (NOW(), ${userId}, ${filmId}, '${content}')")
    void newReview(@Param("userId")int userId, @Param("filmId")int filmId, @Param("content")String content);

    @Delete("DELETE FROM review WHERE user_id = ${userId} AND film_id = ${filmId} AND time = ${time}")
    void deleteReview(@Param("userId")int userId, @Param("filmId")int filmId, @Param("time")Date time);
}
