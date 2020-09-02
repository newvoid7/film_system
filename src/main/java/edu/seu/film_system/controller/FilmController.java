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
    @RequestMapping("/all")
    @ResponseBody
    public ResultDTO<Film> findAll() throws Exception{
        return filmService.findAllFilm();
    }

    // http://localhost:8256/film_system/film/allSum
    @RequestMapping("/allSum")
    @ResponseBody
    public ResultDTO<String> findAllSummary() throws Exception{
        return filmService.findAllSummary();
    }

    // 通过 url 地址传递参数
    // http://127.0.0.1:8256/film_system/film/find/longerThan/80
    @RequestMapping("/find/longerThan/{leastDur}")
    @ResponseBody
    public ResultDTO<Film> findFilmLongerThan(@PathVariable("leastDur")int leastDur) throws Exception{
        return filmService.findFilmLongerThan(leastDur);
    }
}
