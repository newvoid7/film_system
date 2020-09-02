package edu.seu.film_system.service;

import edu.seu.film_system.pojo.Film;
import edu.seu.film_system.pojo.ResultDTO;

import java.util.List;

public interface FilmService {
    /*
    List<Film> findAllFilm();
    List<String> findAllSummary();
    List<Film> findFilmLongerThan(int pd);
    */
    ResultDTO<Film> findAllFilm();
    ResultDTO<String> findAllSummary();
    ResultDTO<Film> findFilmLongerThan(int leastDur);
}
