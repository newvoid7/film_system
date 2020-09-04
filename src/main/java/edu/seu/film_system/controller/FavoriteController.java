package edu.seu.film_system.controller;

import edu.seu.film_system.pojo.Favorite;
import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("favorite")
public class FavoriteController {
    @Autowired
    FavoriteService favoriteService;

    // http://127.0.0.1:8256/film_system/favorite/all
    // 搜索出所有收藏（仅测试）
    @RequestMapping("/all")
    @ResponseBody
    public ResultDTO<Favorite> findAll() {
        ResultDTO<Favorite> resultDTO = new ResultDTO<>();
        resultDTO=favoriteService.findAllFavorite();
        return resultDTO;
    }

    // http://127.0.0.1:8256/film_system/favorite/user=1
    // 搜索出某一用户的所有收藏（需要用户ID）
    // 关键字在 url 中，地址栏传值
    @RequestMapping("/user={userId}")
    @ResponseBody
    public ResultDTO<Favorite> searchByUser(@PathVariable("userId")int userId) {
        return favoriteService.searchByUser(userId);
    }

    // http://127.0.0.1:8256/film_system/favorite/film=1
    // 搜索出关于某一电影的收藏
    // 关键字在 url 中，地址栏传值
    @RequestMapping("/film={filmId}")
    @ResponseBody
    public ResultDTO<Favorite> searchByFilm(@PathVariable("filmId")int filmId) {
        return favoriteService.searchByFilm(filmId);
    }

    // http://127.0.0.1:8256/film_system/favorite/add
    // 新增某个收藏，接收 Json 数据
    // 需要用户ID、电影ID
    @RequestMapping("/add")
    @ResponseBody
    public int addFavorite(@RequestBody Favorite favorite) {
        return favoriteService.addFavorite(favorite);
    }

    // 删除某个收藏，接受 Json 数据
    // http://127.0.0.1:8256/film_system/favorite/delete
    @RequestMapping("/delete")
    @ResponseBody
    public int deleteFavorite(@RequestBody Favorite favorite) {
        return favoriteService.deleteFavorite(favorite);
    }

}
