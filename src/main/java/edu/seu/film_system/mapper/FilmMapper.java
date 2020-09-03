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

    @Select("SELECT * FROM film WHERE duration >= ${leastDur}")
    List<Film> findFilmLongerThan(@Param("leastDur") int leastDur);

    @Select("SELECT * FROM film WHERE name LIKE '${keyWord}'")
    List<Film> searchByName(@Param("keyWord") String keyWord);

    @Select("SELECT * FROM film WHERE summary LIKE '${keyWord}'")
    List<Film> searchBySummary(@Param("keyWord") String keyWord);

    @Select("SELECT * FROM film WHERE name REGEXP \"${keyWord}\" OR summary REGEXP \"${keyWord}\"")
    List<Film> fuzzySearch1(@Param("keyWord") String keyWord);

    @Select("SELECT * FROM film WHERE tag REGEXP \"${tag}\"")
    List<Film> fuzzySearch2(@Param("tag") String tag);

    @Select("SELECT * FROM film WHERE (name REGEXP \"${keyWord}\" OR summary REGEXP \"${keyWord}\") AND tag REGEXP \"${tag}\"")
    List<Film> fuzzySearch3(@Param("keyWord") String keyWord, @Param("tag") String tag);

}
