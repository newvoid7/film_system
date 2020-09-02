package edu.seu.film_system.controller;

import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.pojo.Review;
import edu.seu.film_system.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    // http://127.0.0.1:8256/film_system/review/all
    @RequestMapping("/all")
    @ResponseBody
    public ResultDTO<Review> findAll() throws Exception {
        ResultDTO<Review> resultDTO = new ResultDTO<>();
        resultDTO=reviewService.findAllReview();
        return resultDTO;
    }

    // http://127.0.0.1:8256/film_system/review/user=1
    @RequestMapping("/user={userId}")
    @ResponseBody
    public ResultDTO<Review> searchByUser(@PathVariable("userId")int userId) throws Exception {
        return reviewService.searchByUser(userId);
    }

    // http://127.0.0.1:8256/film_system/review/film=1
    @RequestMapping("/film={filmId}")
    @ResponseBody
    public ResultDTO<Review> searchByFilm(@PathVariable("filmId")int filmId) throws Exception {
        return reviewService.searchByFilm(filmId);
    }

    // 接收 Json 数据
    // 从 http://127.0.0.1:8256/film_system/testNewReview.html 跳转;
    @RequestMapping("/new")
    @ResponseBody
    public String newReview(@RequestBody Review review) throws Exception {
        System.out.println(review.toString());
        reviewService.newReview(review);
        return "ok";
    }


    // 从 http://127.0.0.1:8256/film_system/testNewReview.html 跳转;
    @RequestMapping("/new")
    @ResponseBody
    public String deleteReview(@RequestBody Review review) throws Exception {
        System.out.println(review.toString());
        reviewService.newReview(review);
        return "ok";
    }
}

