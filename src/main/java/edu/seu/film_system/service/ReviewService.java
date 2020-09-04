package edu.seu.film_system.service;

import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.pojo.Review;

public interface ReviewService {
    ResultDTO<Review> findAllReview();
    ResultDTO<Review> searchByUser(int userId);
    ResultDTO<Review> searchByFilm(int filmId);
    int addReview(Review review);
    ResultDTO<Review> findReviewByReview(Review review);
}
