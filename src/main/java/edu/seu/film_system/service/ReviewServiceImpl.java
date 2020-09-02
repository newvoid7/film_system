package edu.seu.film_system.service;

import edu.seu.film_system.mapper.ReviewMapper;
import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.pojo.Review;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service("reviewService")
@Transactional
public class ReviewServiceImpl implements ReviewService {
    @Resource
    ReviewMapper reviewMapper;

    @Override
    public ResultDTO<Review> findAllReview() {
        ResultDTO<Review> resultDTO = new ResultDTO<>();
        resultDTO.setData(reviewMapper.findAllReview());
        resultDTO.setCode(2);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<Review> searchByUser(int userId) {
        ResultDTO<Review> resultDTO = new ResultDTO<>();
        resultDTO.setData(reviewMapper.searchByUser(userId));
        resultDTO.setCode(2);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<Review> searchByFilm(int filmId) {
        ResultDTO<Review> resultDTO = new ResultDTO<>();
        resultDTO.setData(reviewMapper.searchByFilm(filmId));
        resultDTO.setCode(2);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public void newReview(Review review) {
        reviewMapper.newReview(review.getUserId(), review.getFilmId(), review.getContent());
    }

    @Override
    public void deleteReview(Review review) {
        reviewMapper.deleteReview(review.getUserId(), review.getFilmId(), review.getTime());
    }
}
