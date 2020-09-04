package edu.seu.film_system.service;

import edu.seu.film_system.pojo.Favorite;
import edu.seu.film_system.pojo.ResultDTO;

public interface FavoriteService {
    ResultDTO<Favorite> findAllFavorite();
    ResultDTO<Favorite> searchByUser(int userId);
    ResultDTO<Favorite> searchByFilm(int filmId);
    int addFavorite(Favorite favorite);
    int deleteFavorite(Favorite favorite);
}
