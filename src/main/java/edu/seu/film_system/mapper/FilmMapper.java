package edu.seu.film_system.mapper;

import edu.seu.film_system.pojo.Film;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FilmMapper {
    @Select("SELECT * FROM film")
    List<Film> findAllFilm();

    @Select("SELECT summary FROM film")
    List<String> findAllSummary();

    @Select("SELECT * FROM film WHERE duration >= #{leastDur}")
    List<Film> findFilmLongerThan(@Param("leastDur") int leastDur);

}
