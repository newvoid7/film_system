package edu.seu.film_system.controller;

import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.pojo.Review;
import edu.seu.film_system.pojo.User;
import edu.seu.film_system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

// 多表查询，同时返回

@Controller
@RequestMapping("advance")
public class AdvanceController {

    @Autowired
    UserService userService;

    @Autowired
    FilmService filmService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    RecordService recordService;

    @Autowired
    FavoriteService favoriteService;

    // 内部类：为了同时访问评论和对应的用户数据
    private class ReviewAndUser {
        private Review review;
        private User user;

        public ReviewAndUser() {
        }

        public ReviewAndUser(Review review, User user) {
            this.review = review;
            this.user = user;
        }

        public Review getReview() {
            return review;
        }

        public void setReview(Review review) {
            this.review = review;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        @Override
        public String toString() {
            return "ReviewAndUser{" +
                    "review=" + review +
                    ", user=" + user +
                    '}';
        }
    }

    // 同时访问评论和对应的用户
    // http://127.0.0.1:8256/film_system/advance/findReviewByFilm/film=1
    @RequestMapping("/findReviewByFilm/film={filmId}")
    @ResponseBody
    public ResultDTO<ReviewAndUser> findReviewByFilm(@PathVariable("filmId") int filmId) {
        ResultDTO<ReviewAndUser> resultDTO = new ResultDTO<>();
        List<ReviewAndUser> list = new ArrayList<>();
        ReviewAndUser reviewAndUser = new ReviewAndUser();
        User user = new User();
        ResultDTO<Review> reviewResultDTO = reviewService.searchByFilm(filmId);
        List<Review> reviewList = reviewResultDTO.getData();
        for (Review review: reviewList) {
            reviewAndUser = new ReviewAndUser();
            reviewAndUser.setReview(review);
            user = userService.getUserById(review.getUser_id()).getData().get(0);
            reviewAndUser.setUser(user);
            list.add(reviewAndUser);
        }
        resultDTO.setData(list);
        resultDTO.setMsg("OK");
        resultDTO.setCode(20);
        return resultDTO;
    }

}
