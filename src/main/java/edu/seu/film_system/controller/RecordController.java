package edu.seu.film_system.controller;

import edu.seu.film_system.pojo.Record;
import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("record")
public class RecordController {

    @Autowired
    RecordService recordService;

    // http://127.0.0.1:8256/film_system/record/all
    // 搜索出所有观影记录
    @RequestMapping("/all")
    @ResponseBody
    public ResultDTO<Record> findAll() {
        return recordService.findAllRecord();
    }

    // http://127.0.0.1:8256/film_system/record/find/user=1
    // 按用户 ID 搜索观影记录
    // TODO 潜在风险：涉及隐私，通过 url 直接访问
    @RequestMapping("/find/user={userId}")
    @ResponseBody
    public ResultDTO<Record> findRecordByUserId(@PathVariable("userId") int userId) {
        return recordService.findRecordByUserId(userId);
    }

    // http://127.0.0.1:8256/film_system/record/find/film=1
    // 按电影 ID 搜索观影记录
    // TODO 可能用不上
    @RequestMapping("/find/film={filmId}")
    @ResponseBody
    public ResultDTO<Record> findRecordByFilmId(@PathVariable("filmId") int filmId) {
        return recordService.findRecordByFilmId(filmId);
    }

    // http://127.0.0.1:8256/film_system/record/add
    // 新增观影记录
    // 从前台传 json
    @RequestMapping("/add")
    @ResponseBody
    public ResultDTO<Record> addRecord(@RequestBody Record record) {
        if (recordService.findRecordByUserAndFilm(record.getUser_id(), record.getFilm_id())) {
            return recordService.updateRecord(record);
        } else {
            return recordService.addRecord(record);
        }
    }

    // http://127.0.0.1:8256/film_system/record/update
    // 更新观影记录（时间戳），新的“上一次浏览位置”
    // 从前台传 json
    @RequestMapping("/update")
    @ResponseBody
    public ResultDTO<Record> updateRecord(@RequestBody Record record) {
        return recordService.updateRecord(record);
    }

    // http://127.0.0.1:8256/film_system/record/findRecordByRecord
    // 查找观影记录
    // 从前台传 json
    @RequestMapping("/findRecordByRecord")
    @ResponseBody
    public ResultDTO<Record> findRecordByRecord(@RequestBody Record record) {
        return recordService.findRecordByRecord(record);
    }
}
