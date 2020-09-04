package edu.seu.film_system.service;

import edu.seu.film_system.mapper.FilmMapper;
import edu.seu.film_system.pojo.Film;
import edu.seu.film_system.pojo.ResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("filmService")
@Transactional
public class FilmServiceImpl implements FilmService{
    @Resource
    FilmMapper filmMapper;

    @Override
    public ResultDTO<Film> findAllFilm() {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<Film> list = new ArrayList<>();
        try {
            list = filmMapper.findAllFilm();
            if (list.isEmpty()) {
                resultDTO.setCode(21);
                resultDTO.setMsg("Find");
            } else {
                resultDTO.setCode(20);
                resultDTO.setMsg("Find all film: Success");
            }
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find all film: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> getFilmById(int filmId) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<Film> list = new ArrayList<>();
        try {
            list = filmMapper.getFilmById(filmId);
            resultDTO.setCode(20);
            resultDTO.setMsg("Find film by ID: Success");
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find film by ID: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public ResultDTO<String> findAllSummary() {
        ResultDTO<String> resultDTO = new ResultDTO<>();
        List<String> list = new ArrayList<>();
        try {
            list = filmMapper.findAllSummary();
            resultDTO.setCode(20);
            resultDTO.setMsg("Find all summary: Success");
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find all summary: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> findFilmLongerThan(int leastDur) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<Film> list = new ArrayList<>();
        try {
            list = filmMapper.findFilmLongerThan(leastDur);
            resultDTO.setCode(20);
            resultDTO.setMsg("Find film longer than: Success");
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find film longer than: Database error");
        }
        resultDTO.setData(list);
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
        return fuzzySearch(keyWord, "");
    }

    @Override
    public ResultDTO<Film> fuzzySearch(String keyWord, String tag) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<Film> list = new ArrayList<>();
        if (keyWord.isEmpty() && tag.isEmpty()) {
            resultDTO.setCode(31);
            resultDTO.setMsg("Search in name/summary/tag: Keyword or tags should has value");
        } else {
            if (!keyWord.isEmpty()) {
                String[] sKeyWord = keyWord.split(" |\\+");     // 多关键字，用空格或者加号分开
                keyWord = "";
                for (String each: sKeyWord){
                    keyWord = keyWord + each + ".*";                   // 按序同时匹配多个关键字
                }
            }
            if (!tag.isEmpty()) {
                tag = tag.substring(1, tag.length());                   // 多标签，每个标签前有 +
                String[] sTags = tag.split("\\+");
                tag = "(";
                for (String each: sTags) {
                    tag = tag + ".*" + each + ".*|";
                }
                tag = tag.substring(0, tag.length() - 1);
                tag = tag + "){" + sTags.length + "}";          // 乱序同时匹配多个标签
            }
            try {
                if (keyWord.isEmpty()){
                    list = filmMapper.fuzzySearch2(tag);
                } else if(tag.isEmpty()){
                    list = filmMapper.fuzzySearch1(keyWord);
                } else {
                    list = filmMapper.fuzzySearch3(keyWord, tag);
                }
                if (list.isEmpty()) {
                    resultDTO.setCode(21);
                    resultDTO.setMsg("Search in name/summary/tag: Success but empty");
                } else {
                    resultDTO.setCode(20);
                    resultDTO.setMsg("Search in name/summary/tag: Success");
                }
            } catch (Exception e) {
                resultDTO.setCode(11);
                resultDTO.setMsg("Search in name/summary/tag: Database error");
            }
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public int viewCountIncrease(int filmId) {
        int returnValue = 0;
        try {
            filmMapper.viewCountIncrease(filmId);
            returnValue = 20;
        } catch (Exception e) {
            returnValue = 11;
        }
        return returnValue;
    }

    @Override
    public ResultDTO<Film> topFilm(int topN) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<Film> list = new ArrayList<>();
        try {
            list = filmMapper.topFilm(topN);
            resultDTO.setCode(20);
            resultDTO.setMsg("Get top films: Success");
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Get top films: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }
}
