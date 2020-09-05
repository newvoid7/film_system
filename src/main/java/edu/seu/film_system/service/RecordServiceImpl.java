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
            if (list.isEmpty()) {
                resultDTO.setCode(21);
                resultDTO.setMsg("Find all record: Success but no data");
            } else {
                resultDTO.setCode(20);
                resultDTO.setMsg("Find all record: Success");
            }
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
            if (list.isEmpty()) {
                resultDTO.setCode(21);
                resultDTO.setMsg("Find record by user id: Success but no data");
            } else {
                resultDTO.setCode(20);
                resultDTO.setMsg("Find record by user id: Success");
            }
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
            if (list.isEmpty()) {
                resultDTO.setCode(21);
                resultDTO.setMsg("Find record by film id: Success but no data");
            } else {
                resultDTO.setCode(20);
                resultDTO.setMsg("Find record by film id: Success");
            }
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find record by film id: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public boolean findRecordByUserAndFilm(int userId, int filmId) {
        List<Record> list = recordMapper.findRecordByUserAndFilm(userId,filmId);
        if (list.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public ResultDTO<Record> addRecord(Record record) {
        ResultDTO<Record> resultDTO = new ResultDTO<>();
        List<Record> list = new ArrayList<>();
        try {
            int code = recordMapper.addRecord(record);
            if (code > 0) {
                list.add(record);
                resultDTO.setCode(20);
                resultDTO.setMsg("Add record: Success");
            } else {
                resultDTO.setCode(12);
                resultDTO.setMsg("Add record: Fail. SQL error");
            }
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Add record: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public ResultDTO<Record> updateRecord(Record record) {
        ResultDTO<Record> resultDTO = new ResultDTO<>();
        List<Record> list = new ArrayList<>();
        try {
            int code = recordMapper.updateRecord(record);
            if (code > 0) {
                list.add(record);
                resultDTO.setCode(20);
                resultDTO.setMsg("Update record: Success");
                resultDTO.setData(list);
            } else {
                resultDTO = addRecord(record);
            }
        } catch (Exception e) {
            resultDTO = addRecord(record);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<Record> findRecordByRecord(Record record) {
        ResultDTO<Record> resultDTO = new ResultDTO<>();
        List<Record> list = new ArrayList<>();
        try {
            list.add(recordMapper.findRecordByRecord(record));
            resultDTO.setCode(20);
            resultDTO.setMsg("Find record by record: Success");
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find record by record: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }
}
