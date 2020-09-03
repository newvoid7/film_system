package edu.seu.film_system.controller;

import edu.seu.film_system.pojo.Record;
import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        ResultDTO<Record> resultDTO = new ResultDTO<>();
        resultDTO = recordService.findAllRecord();
        return resultDTO;
    }
}
