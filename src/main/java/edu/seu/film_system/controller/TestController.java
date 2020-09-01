package edu.seu.film_system.controller;

import edu.seu.film_system.pojo.Info;
import edu.seu.film_system.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    InfoService infoService;

    // http://127.0.0.1:8256/film/test/toIndex
    @RequestMapping("/toIndex")
    public String toIndex() throws Exception{
        System.out.println("Executed \"toIndex\"");
        return "index";
    }

    // http://127.0.0.1:8256/film/test/testMaV
    @RequestMapping("/testMaV")
    public ModelAndView testMaV(ModelAndView mav)throws Exception{
        // Request 域中的值，相当于函数内的值
        mav.addObject("name","函数内 mav");
        mav.setViewName("index");
        return mav;
    }

    // http://127.0.0.1:8256/film/test/findAll
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Info> findAll() throws Exception{
        // 加上 @ResponseBody 后就是 Response 域中的值
        return infoService.findAllInfo();
    }

}
