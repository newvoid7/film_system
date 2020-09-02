package edu.seu.film_system.service;

import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.pojo.Review;

import java.util.Date;

public interface ReviewService {
    ResultDTO<Review> findAllReview();
    ResultDTO<Review> searchByUser(int userId);
    ResultDTO<Review> searchByFilm(int filmId);
    void newReview(Review review);
    void deleteReview(Review review);
}
