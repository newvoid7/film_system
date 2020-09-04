package edu.seu.film_system.service;

import edu.seu.film_system.mapper.ReviewMapper;
import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.pojo.Review;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("reviewService")
@Transactional
public class ReviewServiceImpl implements ReviewService {
    @Resource
    ReviewMapper reviewMapper;

    @Override
    public ResultDTO<Review> findAllReview() {
        ResultDTO<Review> resultDTO = new ResultDTO<>();
        List<Review> list = new ArrayList<>();
        try {
            list = reviewMapper.findAllReview();
            if (list.isEmpty()) {
                resultDTO.setCode(21);
                resultDTO.setMsg("Find all Review: Success but no data");
            } else {
                resultDTO.setCode(20);
                resultDTO.setMsg("Find all Review: Success");
            }
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find all Review: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public ResultDTO<Review> searchByUser(int userId) {
        ResultDTO<Review> resultDTO = new ResultDTO<>();
        List<Review> list = new ArrayList<>();
        try {
            list = reviewMapper.searchByUser(userId);
            if (list.isEmpty()) {
                resultDTO.setCode(21);
                resultDTO.setMsg("Find review by userId: Success but no data");
            } else {
                resultDTO.setCode(20);
                resultDTO.setMsg("Find review by userId: Success");
            }
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find review by userId: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public ResultDTO<Review> searchByFilm(int filmId) {
        ResultDTO<Review> resultDTO = new ResultDTO<>();
        List<Review> list = new ArrayList<>();
        try {
            list = reviewMapper.searchByFilm(filmId);
            if (list.isEmpty()) {
                resultDTO.setCode(21);
                resultDTO.setMsg("Find review by filmId: Success but no data");
            } else {
                resultDTO.setCode(20);
                resultDTO.setMsg("Find review by filmId: Success");
            }
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find review by filmId: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public int addReview(Review review) {
        int returnValue = 0;
        try {
            int code = reviewMapper.addReview(review);
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
    public ResultDTO<Review> findReviewByReview(Review review) {
        ResultDTO<Review> resultDTO = new ResultDTO<>();
        List<Review> list = new ArrayList<>();
        try {
            Review resultReview = reviewMapper.findReviewByReview(review);
            if (resultReview == null) {
                resultDTO.setCode(21);
                resultDTO.setMsg("Find review by review: Success but no data");
            } else {
                list.add(resultReview);
                resultDTO.setCode(20);
                resultDTO.setMsg("Find review by review: Success");
            }
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find review by review: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }
}
