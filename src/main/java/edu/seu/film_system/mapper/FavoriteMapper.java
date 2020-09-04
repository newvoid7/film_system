package edu.seu.film_system.mapper;

import edu.seu.film_system.pojo.Favorite;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FavoriteMapper {
    @Select("SELECT * FROM favorite")
    List<Favorite> findAllFavorite();

    @Select("SELECT * FROM favorite WHERE user_id = ${userId}")
    List<Favorite> findFavoriteByUserId(@Param("userId") int userId);

    @Select("SELECT * FROM favorite WHERE film_id = ${filmId}")
    List<Favorite> findFavoriteByFilmId(@Param("filmId") int filmId);

    // INSERT
    int addFavorite(Favorite favorite);

    // DELETE
    int deleteFavorite(Favorite favorite);

}
