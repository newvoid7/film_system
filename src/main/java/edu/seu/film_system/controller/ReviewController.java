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
    public ResultDTO<Review> findAll() throws Exception {
        ResultDTO<Review> resultDTO = new ResultDTO<>();
        resultDTO=reviewService.findAllReview();
        return resultDTO;
    }

    // http://127.0.0.1:8256/film_system/review/user=1
    // 搜索出某一用户发表的所有评论（需要用户ID）
    // 关键字在 url 中，地址栏传值
    @RequestMapping("/user={userId}")
    @ResponseBody
    public ResultDTO<Review> searchByUser(@PathVariable("userId")int userId) throws Exception {
        return reviewService.searchByUser(userId);
    }

    // http://127.0.0.1:8256/film_system/review/film=1
    // 搜索出关于某一电影的所有评论
    // 关键字在 url 中，地址栏传值
    @RequestMapping("/film={filmId}")
    @ResponseBody
    public ResultDTO<Review> searchByFilm(@PathVariable("filmId")int filmId) throws Exception {
        return reviewService.searchByFilm(filmId);
    }

    // http://127.0.0.1:8256/film_system/review/new
    // 接收 Json 数据
    // 从 http://127.0.0.1:8256/film_system/testNewReview.html 跳转到此
    // 新增某个评论，使用上述 html 中描述的 json 格式传递信息
    // 需要用户ID、电影ID、评论内容
    // 注意：默认设置评论时间为服务器当前时间，不可更改
    @RequestMapping("/new")
    @ResponseBody
    public String newReview(@RequestBody Review review) throws Exception {
        System.out.println(review.toString());
        reviewService.newReview(review);
        return "ok";
    }


    // 从 http://127.0.0.1:8256/film_system/testNewReview.html 跳转;
    // TODO 删除某条评论，需要评论的主键信息：用户ID、电影ID、时间戳
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteReview(@RequestBody Review review) throws Exception {
        System.out.println(review.toString());
        reviewService.newReview(review);
        return "ok";
    }
}

