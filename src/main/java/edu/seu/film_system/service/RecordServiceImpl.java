package edu.seu.film_system.service;

import edu.seu.film_system.mapper.RecordMapper;
import edu.seu.film_system.pojo.Record;
import edu.seu.film_system.pojo.ResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("recordService")
@Transactional
public class RecordServiceImpl implements RecordService{
    @Resource
    RecordMapper recordMapper;

    @Override
    public ResultDTO<Record> findAllRecord() {
        ResultDTO<Record> resultDTO = new ResultDTO<>();
        List<Record> list = new ArrayList<>();
        try {
            list = recordMapper.findAllRecord();
            resultDTO.setCode(20);
            resultDTO.setMsg("Find all record: Success");
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find all record: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public ResultDTO<Record> findRecordByUserId(int userId) {
        ResultDTO<Record> resultDTO = new ResultDTO<>();
        List<Record> list = new ArrayList<>();
        try {
            list = recordMapper.findRecordByUserId(userId);
            resultDTO.setCode(20);
            resultDTO.setMsg("Find record by user id: Success");
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find record by user id: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public ResultDTO<Record> findRecordByFilmId(int filmId) {
        ResultDTO<Record> resultDTO = new ResultDTO<>();
        List<Record> list = new ArrayList<>();
        try {
            list = recordMapper.findRecordByFilmId(filmId);
            resultDTO.setCode(20);
            resultDTO.setMsg("Find record by film id: Success");
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find record by film id: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }
}
