package edu.seu.film_system.controller;

import edu.seu.film_system.pojo.*;
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

    // 内部类：为了同时访问观影记录和对应的电影数据
    private class RecordAndFilm {
        private Record record;
        private Film film;

        public RecordAndFilm() {
        }

        public RecordAndFilm(Record record, Film film) {
            this.record = record;
            this.film = film;
        }

        public Record getRecord() {
            return record;
        }

        public void setRecord(Record record) {
            this.record = record;
        }

        public Film getFilm() {
            return film;
        }

        public void setFilm(Film film) {
            this.film = film;
        }

        @Override
        public String toString() {
            return "RecordAndFilm{" +
                    "record=" + record +
                    ", film=" + film +
                    '}';
        }
    }

    // 内部类：为了同时访问观影记录和对应的电影数据
    private class FavoriteAndFilm {
        private Favorite favorite;
        private Film film;

        public FavoriteAndFilm() {
        }

        public FavoriteAndFilm(Favorite favorite, Film film) {
            this.favorite = favorite;
            this.film = film;
        }

        public Favorite getFavorite() {
            return favorite;
        }

        public void setFavorite(Favorite favorite) {
            this.favorite = favorite;
        }

        public Film getFilm() {
            return film;
        }

        public void setFilm(Film film) {
            this.film = film;
        }

        @Override
        public String toString() {
            return "FavoriteAndFilm{" +
                    "favorite=" + favorite +
                    ", film=" + film +
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

    // 同时访问观影记录和对应的电影
    // http://127.0.0.1:8256/film_system/advance/findRecordByUser/user=1
    @RequestMapping("/findRecordByUser/user={userId}")
    @ResponseBody
    public ResultDTO<RecordAndFilm> findRecordByUser(@PathVariable("userId") int userId) {
        ResultDTO<RecordAndFilm> resultDTO = new ResultDTO<>();
        List<RecordAndFilm> list = new ArrayList<>();
        RecordAndFilm recordAndFilm = new RecordAndFilm();
        Film film = new Film();
        ResultDTO<Record> recordResultDTO = recordService.findRecordByUserId(userId);
        List<Record> recordList = recordResultDTO.getData();
        for (Record record: recordList) {
            recordAndFilm = new RecordAndFilm();
            recordAndFilm.setRecord(record);
            film = filmService.getFilmById(record.getFilm_id()).getData().get(0);
            recordAndFilm.setFilm(film);
            list.add(recordAndFilm);
        }
        resultDTO.setData(list);
        resultDTO.setMsg("OK");
        resultDTO.setCode(20);
        return resultDTO;
    }

    // 同时访问收藏和对应的电影
    // http://127.0.0.1:8256/film_system/advance/findFavoriteByUser/user=1
    @RequestMapping("/findFavoriteByUser/user={userId}")
    @ResponseBody
    public ResultDTO<FavoriteAndFilm> findFavoriteByUser(@PathVariable("userId") int userId) {
        ResultDTO<FavoriteAndFilm> resultDTO = new ResultDTO<>();
        List<FavoriteAndFilm> list = new ArrayList<>();
        FavoriteAndFilm favoriteAndFilm = new FavoriteAndFilm();
        Film film = new Film();
        ResultDTO<Favorite> favoriteResultDTO = favoriteService.searchByUser(userId);
        List<Favorite> favoriteList = favoriteResultDTO.getData();
        for (Favorite favorite: favoriteList) {
            favoriteAndFilm = new FavoriteAndFilm();
            favoriteAndFilm.setFavorite(favorite);
            film = filmService.getFilmById(favorite.getFilm_id()).getData().get(0);
            favoriteAndFilm.setFilm(film);
            list.add(favoriteAndFilm);
        }
        resultDTO.setData(list);
        resultDTO.setMsg("OK");
        resultDTO.setCode(20);
        return resultDTO;
    }


}
