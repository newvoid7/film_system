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
    // 搜索出所有评论（仅测试）
    @RequestMapping("/all")
    @ResponseBody
    public ResultDTO<Review> findAll() {
        ResultDTO<Review> resultDTO = new ResultDTO<>();
        resultDTO=reviewService.findAllReview();
        return resultDTO;
    }

    // http://127.0.0.1:8256/film_system/review/user=1
    // 搜索出某一用户发表的所有评论（需要用户ID）
    // 关键字在 url 中，地址栏传值
    @RequestMapping("/user={userId}")
    @ResponseBody
    public ResultDTO<Review> searchByUser(@PathVariable("userId")int userId) {
        return reviewService.searchByUser(userId);
    }

    // http://127.0.0.1:8256/film_system/review/film=1
    // 搜索出关于某一电影的所有评论
    // 关键字在 url 中，地址栏传值
    @RequestMapping("/film={filmId}")
    @ResponseBody
    public ResultDTO<Review> searchByFilm(@PathVariable("filmId")int filmId) {
        return reviewService.searchByFilm(filmId);
    }

    // http://127.0.0.1:8256/film_system/review/add
    // 新增某个评论，接收 Json 数据
    // 需要用户ID、电影ID、评论内容
    // 注意：默认设置评论时间为服务器当前时间，不可更改
    @RequestMapping("/add")
    @ResponseBody
    public int newReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    // http://127.0.0.1:8256/film_system/review/findReviewByReview
    // 根据评论搜评论，要求主键做输入：用户ID、电影ID、时间
    // 前台传Json
    @RequestMapping("/findReviewByReview")
    @ResponseBody
    public ResultDTO<Review> findReviewByReview(@RequestBody Review review) {
        return reviewService.findReviewByReview(review);
    }

}

