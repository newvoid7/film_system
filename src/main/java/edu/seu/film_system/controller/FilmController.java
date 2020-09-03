package edu.seu.film_system.controller;

import edu.seu.film_system.pojo.Film;
import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("film")
public class FilmController {

    @Autowired
    FilmService filmService;

    // http://localhost:8256/film_system/film/all
    // 搜索出所有的电影
    @RequestMapping("/all")
    @ResponseBody
    public ResultDTO<Film> findAll() throws Exception{
        return filmService.findAllFilm();
    }

    // http://localhost:8256/film_system/film/allSum
    // 搜索所有电影的简介（仅测试）
    @RequestMapping("/allSum")
    @ResponseBody
    public ResultDTO<String> findAllSummary() throws Exception{
        return filmService.findAllSummary();
    }

    // 通过 url 地址传递参数
    // http://127.0.0.1:8256/film_system/film/find/longerThan/80
    // 搜索时长长于某个值的电影（仅测试）
    @RequestMapping("/find/longerThan/{leastDur}")
    @ResponseBody
    public ResultDTO<Film> findFilmLongerThan(@PathVariable("leastDur")int leastDur) throws Exception{
        return filmService.findFilmLongerThan(leastDur);
    }

    // http://127.0.0.1:8256/film_system/film/find/name=the
    // 模糊查询：名称中含有某个值的电影（可以中文）
    // 关键字在 url 中，restful 风格地址栏传值
    @RequestMapping("/find/name={keyWord}")
    @ResponseBody
    public ResultDTO<Film> searchInTitle(@PathVariable("keyWord")String keyWord) throws Exception{
        return filmService.searchInTitle(keyWord);
    }

    // http://127.0.0.1:8256/film_system/film/find/summary=肖申克
    // 模糊查询：简介中含有某个值的电影（可以中文）
    // 关键字在 url 中，restful 风格地址栏传值
    @RequestMapping("/find/summary={keyWord}")
    @ResponseBody
    public ResultDTO<Film> searchInSummary(@PathVariable("keyWord")String keyWord) throws Exception{
        return filmService.searchInSummary(keyWord);
    }

    // http://127.0.0.1:8256/film_system/film/find/keyword=肖申克
    // 模糊查询：简介或名称中含有某个值的电影（可以中文）
    // 关键字在 url 中，restful 风格地址栏传值
    @RequestMapping("/find/keyword={keyWord}")
    @ResponseBody
    public ResultDTO<Film> fuzzySearch(@PathVariable("keyWord")String keyWord) throws Exception{
        return filmService.fuzzySearch(keyWord);
    }
}
