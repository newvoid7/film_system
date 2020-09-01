package edu.seu.film_system.controller;

import edu.seu.film_system.pojo.Film;
import edu.seu.film_system.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("film")
public class FilmController {

    @Autowired
    FilmService filmService;

    //http://localhost:8256/film/film/findFilm
    @RequestMapping("/findFilm")
    @ResponseBody
    public List<Film> findAll() throws Exception{
        return filmService.findAllFilm();
    }

    // http://localhost:8256/film/film/findFilmSum
    @RequestMapping("/findFilmSum")
    @ResponseBody
    public List<String> findAllSummary() throws Exception{
        return filmService.findAllSummary();
    }

    // http://127.0.0.1:8256/film/film/findSomeFilm
    @RequestMapping("/findSomeFilm")
    @ResponseBody
    public List<Film> findFilmLongerThan() throws Exception{
        return filmService.findFilmLongerThan(80);
    }
}
