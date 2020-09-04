package edu.seu.film_system.mapper;

import edu.seu.film_system.pojo.Review;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    // INSERT
    int addReview(Review review);

    // SELECT
    Review findReviewByReview(Review review);

}
