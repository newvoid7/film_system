package edu.seu.film_system.service;

import edu.seu.film_system.pojo.Film;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FilmService {
    @Select("SELECT * FROM movie")
    List<Film> findAllFilm();

    @Select("SELECT summary FROM movie")
    List<String> findAllSummary();

    @Select("SELECT * FROM movie WHERE duration >= #{pd}")
    List<Film> findFilmLongerThan(@Param("pd") int pd);
}
