package edu.seu.film_system.service;

import edu.seu.film_system.mapper.FilmMapper;
import edu.seu.film_system.pojo.Film;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("filmService")
@Transactional
public class FilmServiceImpl implements FilmService{
    @Resource
    FilmMapper filmMapper;

    @Override
    public List<Film> findFilmLongerThan(int pd) {
        return filmMapper.findFilmLongerThan(pd);
    }

    @Override
    public List<String> findAllSummary() {
        return filmMapper.findAllSummary();
    }

    @Override
    public List<Film> findAllFilm() {
        return filmMapper.findAllFilm();
    }
}
