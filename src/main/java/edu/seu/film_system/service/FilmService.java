package edu.seu.film_system.service;

import edu.seu.film_system.pojo.Film;
import edu.seu.film_system.pojo.ResultDTO;

import java.util.List;

public interface FilmService {

    ResultDTO<Film> findAllFilm();
    ResultDTO<String> findAllSummary();
    ResultDTO<Film> findFilmLongerThan(int leastDur);
    // ResultDTO<Film> exactSearch(String keyWord);
    ResultDTO<Film> searchInSummary(String keyWord);
    ResultDTO<Film> searchInTitle(String keyWord);
    ResultDTO<Film> fuzzySearch(String keyWord);
}
