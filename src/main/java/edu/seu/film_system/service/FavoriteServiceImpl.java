package edu.seu.film_system.service;

import edu.seu.film_system.mapper.FavoriteMapper;
import edu.seu.film_system.pojo.Favorite;
import edu.seu.film_system.pojo.ResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("favoriteService")
@Transactional
public class FavoriteServiceImpl implements FavoriteService {
    @Resource
    FavoriteMapper favoriteMapper;

    @Override
    public ResultDTO<Favorite> findAllFavorite() {
        ResultDTO<Favorite> resultDTO = new ResultDTO<>();
        List<Favorite> list = new ArrayList<>();
        try {
            list = favoriteMapper.findAllFavorite();
            if (list.isEmpty()) {
                resultDTO.setCode(21);
                resultDTO.setMsg("Find all favorite: Success but no data");
            } else {
                resultDTO.setCode(20);
                resultDTO.setMsg("Find all favorite: Success");
            }
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find all favorite: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public ResultDTO<Favorite> searchByUser(int userId) {
        ResultDTO<Favorite> resultDTO = new ResultDTO<>();
        List<Favorite> list = new ArrayList<>();
        try {
            list = favoriteMapper.findFavoriteByUserId(userId);
            if (list.isEmpty()) {
                resultDTO.setCode(21);
                resultDTO.setMsg("Find favorite by user ID: Success but no data");
            } else {
                resultDTO.setCode(20);
                resultDTO.setMsg("Find favorite by user ID: Success");
            }
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find favorite by user ID: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public ResultDTO<Favorite> searchByFilm(int filmId) {
        ResultDTO<Favorite> resultDTO = new ResultDTO<>();
        List<Favorite> list = new ArrayList<>();
        try {
            list = favoriteMapper.findFavoriteByFilmId(filmId);
            if (list.isEmpty()) {
                resultDTO.setCode(21);
                resultDTO.setMsg("Find favorite by film ID: Success but no data");
            } else {
                resultDTO.setCode(20);
                resultDTO.setMsg("Find favorite by film ID: Success");
            }
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find favorite by film ID: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public int addFavorite(Favorite favorite) {
        int returnValue = 0;
        try {
            int code = favoriteMapper.addFavorite(favorite);
            if (code > 0) {
                returnValue = 20;
            } else {
                returnValue = 12;
            }
        } catch (Exception e) {
            returnValue = 11;
        }
        return returnValue;
    }

    @Override
    public int deleteFavorite(Favorite favorite) {
        int returnValue = 0;
        try {
            int code = favoriteMapper.deleteFavorite(favorite);
            if (code > 0) {
                returnValue = 20;
            } else {
                returnValue = 12;
            }
        } catch (Exception e) {
            returnValue = 11;
        }
        return returnValue;
    }
}
