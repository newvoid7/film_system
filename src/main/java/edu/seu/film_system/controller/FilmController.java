package edu.seu.film_system.controller;

import edu.seu.film_system.pojo.Film;
import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    // 按照 ID 查找电影，精确查询
    // http://localhost:8256/film_system/film/id=1
    @RequestMapping("/id={filmId}")
    @ResponseBody
    public ResultDTO<Film> findFilmById(@PathVariable("filmId") int filmId) {
        return filmService.getFilmById(filmId);
    }


    // http://localhost:8256/film_system/film/allSum
    // 搜索所有电影的简介
    @RequestMapping("/allSum")
    @ResponseBody
    public ResultDTO<String> findAllSummary() throws Exception{
        return filmService.findAllSummary();
    }

    // 通过 url 地址传递参数
    // http://127.0.0.1:8256/film_system/film/find/longerThan/80
    // 搜索时长长于某个值的电影
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

    // http://127.0.0.1:8256/film_system/film/find/keyword=the
    // 模糊查询：简介或名称中含有某组值的电影
    // 关键字在 url 中，restful 风格地址栏传值
    @RequestMapping("/find/keyword={keyWord}")
    @ResponseBody
    public ResultDTO<Film> fuzzySearch(@PathVariable("keyWord")String keyWord) {
        return filmService.fuzzySearch(keyWord);
    }

    // http://127.0.0.1:8256/film_system/film/find/keyword=the/tag=A
    // 模糊查询：简介或名称中含有某组值的电影，同时满足某个标签（满足标签是必须的，但是可以乱序）
    // 同时可以关键词为空，仅以标签浏览
    // 关键字在 url 中，restful 风格地址栏传值
    @RequestMapping("/find/keyword={keyWord}/tag={tags}")
    @ResponseBody
    public ResultDTO<Film> fuzzySearch(@PathVariable("keyWord")String keyWord, @PathVariable("tags")String tags) {
        // System.out.println(keyWord+tags);
        return filmService.fuzzySearch(keyWord, tags);
    }

    // http://localhost:8256/film_system/film/viewCountIncrease/id=1
    // 观看某个电影，电影的观看数加 1
    // TODO 潜在风险：通过 url 访问即可增加观看数，没有验证
    @RequestMapping("/viewCountIncrease/id={filmId}")
    @ResponseBody
    public String viewCountIncrease(@PathVariable("filmId") int filmId) {
        String msg = "";
        int code = filmService.viewCountIncrease(filmId);
        if (code == 20) {
            msg = "ok";
        } else {
            msg = "Database Error";
        }
        return msg;
    }

    // http://localhost:8256/film_system/film/top5
    // 播放量前 N 的电影
    @RequestMapping("/top{topN}")
    @ResponseBody
    public ResultDTO<Film> getTopFilms(@PathVariable("topN") int topN) {
        return filmService.topFilm(topN);
    }

    // http://localhost:8256/film_system/film/random5
    // 随机选取 N 部电影
    @RequestMapping("/random{randomN}")
    @ResponseBody
    public ResultDTO<Film> getRandomFilms(@PathVariable("randomN") int randomN) {
        ResultDTO<Film> resultDTO = filmService.findAllFilm();
        if (randomN > resultDTO.getData().size()) {
            resultDTO.setCode(31);
            resultDTO.setMsg("Find random films: Request number too big");
        } else {
            List<Film> list = resultDTO.getData();
            List<Film> newList = new ArrayList<>();
            List<Integer> indexList = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < randomN; ++i) {
                int randomIndex = random.nextInt(list.size());
                while (indexList.contains(randomIndex)){       // 重随
                    randomIndex = random.nextInt(list.size());
                }
                indexList.add(randomIndex);
                newList.add(list.get(randomIndex));
            }
            resultDTO.setData(newList);
            resultDTO.setCode(20);
            resultDTO.setMsg("Find random films: Success");
        }
        return resultDTO;
    }
}
