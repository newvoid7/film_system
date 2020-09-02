package edu.seu.film_system.service;

import edu.seu.film_system.mapper.FilmMapper;
import edu.seu.film_system.pojo.Film;
import edu.seu.film_system.pojo.ResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("filmService")
@Transactional
public class FilmServiceImpl implements FilmService{
    @Resource
    FilmMapper filmMapper;

    @Override
    public ResultDTO<Film> findAllFilm() {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        resultDTO.setData(filmMapper.findAllFilm());
        resultDTO.setCode(9);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<String> findAllSummary() {
        ResultDTO<String> resultDTO = new ResultDTO<>();
        resultDTO.setData(filmMapper.findAllSummary());
        resultDTO.setCode(10);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> findFilmLongerThan(int leastDur) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        resultDTO.setData(filmMapper.findFilmLongerThan(leastDur));
        resultDTO.setCode(11);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> searchInSummary(String keyWord) {
        keyWord = '%' + keyWord +'%';
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        resultDTO.setData(filmMapper.searchBySummary(keyWord));
        resultDTO.setCode(11);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> fuzzySearch(String keyWord) {
        keyWord = '%' + keyWord +'%';
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        resultDTO.setData(filmMapper.searchByName(keyWord));
        resultDTO.setCode(11);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> exactSearch(String keyWord) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        resultDTO.setData(filmMapper.searchByName(keyWord));
        resultDTO.setCode(11);
        resultDTO.setMsg("success");
        return resultDTO;
    }
}
