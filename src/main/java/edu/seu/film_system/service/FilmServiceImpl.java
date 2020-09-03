package edu.seu.film_system.service;

import edu.seu.film_system.mapper.FilmMapper;
import edu.seu.film_system.pojo.Film;
import edu.seu.film_system.pojo.ResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("filmService")
@Transactional
public class FilmServiceImpl implements FilmService{
    @Resource
    FilmMapper filmMapper;

    @Override
    public ResultDTO<Film> findAllFilm() {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        resultDTO.setData(filmMapper.findAllFilm());
        resultDTO.setCode(20);
        resultDTO.setMsg("Find all film success");
        return resultDTO;
    }

    @Override
    public ResultDTO<String> findAllSummary() {
        ResultDTO<String> resultDTO = new ResultDTO<>();
        resultDTO.setData(filmMapper.findAllSummary());
        resultDTO.setCode(20);
        resultDTO.setMsg("Find all summary success");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> findFilmLongerThan(int leastDur) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        resultDTO.setData(filmMapper.findFilmLongerThan(leastDur));
        resultDTO.setCode(20);
        resultDTO.setMsg("Find film longer than: Success");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> searchInTitle(String keyWord) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<Film> list = new ArrayList<>();
        if (keyWord.isEmpty()) {
            resultDTO.setCode(31);
            resultDTO.setMsg("Search in name: Keyword cannot be empty");
        } else {
            keyWord = '%' + keyWord +'%';
            try {
                list = filmMapper.searchByName(keyWord);
                resultDTO.setCode(20);
                resultDTO.setMsg("Search in name: Success");
            } catch (Exception e) {
                resultDTO.setCode(11);
                resultDTO.setMsg("Search in name: Database error");
            }
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> searchInSummary(String keyWord) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<Film> list = new ArrayList<>();
        if (keyWord.isEmpty()) {
            resultDTO.setCode(31);
            resultDTO.setMsg("Search in summary: Keyword cannot be empty");
        } else {
            keyWord = '%' + keyWord +'%';
            try {
                list = filmMapper.searchBySummary(keyWord);
                resultDTO.setCode(20);
                resultDTO.setMsg("Search in summary: Success");
            } catch (Exception e) {
                resultDTO.setCode(11);
                resultDTO.setMsg("Search in summary: Database error");
            }
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> fuzzySearch(String keyWord) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<Film> list = new ArrayList<>();
        if (keyWord.isEmpty()) {
            resultDTO.setCode(31);
            resultDTO.setMsg("Search in name/summary: Keyword cannot be empty");
        } else {
            keyWord = '%' + keyWord +'%';
            try {
                List<Film> list1 = filmMapper.searchByName(keyWord);
                List<Film> list2 = filmMapper.searchBySummary(keyWord);
                list = Stream.of(list1, list2)
                        .flatMap(Collection::stream)
                        .distinct()
                        .collect(Collectors.toList());
                resultDTO.setCode(20);
                resultDTO.setMsg("Search in name/summary: Success");
            } catch (Exception e) {
                resultDTO.setCode(11);
                resultDTO.setMsg("Search in name/summary: Database error");
            }
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    /*
    @Override
    public ResultDTO<Film> exactSearch(String keyWord) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        resultDTO.setData(filmMapper.searchByName(keyWord));
        resultDTO.setCode(11);
        resultDTO.setMsg("success");
        return resultDTO;
    }

     */
}
