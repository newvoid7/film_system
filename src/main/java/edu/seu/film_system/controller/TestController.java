package edu.seu.film_system.controller;

import edu.seu.film_system.pojo.Info;
import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    InfoService infoService;

    // http://127.0.0.1:8256/film_system/test/toIndex
    @RequestMapping("/toIndex")
    public String toIndex() throws Exception{
        System.out.println("Executed \"toIndex\"");
        return "index";
    }

    // http://127.0.0.1:8256/film_system/test/testMaV
    @RequestMapping("/testMaV")
    public ModelAndView testMaV(ModelAndView mav)throws Exception{
        // Request 域中的值，相当于函数内的值
        mav.addObject("name","函数内 mav");
        mav.setViewName("index");
        return mav;
    }

    // http://127.0.0.1:8256/film_system/test/findAll
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Info> findAll() throws Exception{
        // 加上 @ResponseBody 后就是 Response 域中的值
        return infoService.findAllInfo();
    }

    // http://127.0.0.1:8256/film_system/test/findAll2
    @RequestMapping("/findAll2")
    @ResponseBody
    public ResultDTO<Info> findAll2() throws Exception{
        return infoService.findAllInfo2();
    }

    // 通过静态页面 http://127.0.0.1:8256/film_system/test.html 登录，跳转到此函数，然后跳转到动态页面
    @PostMapping("/login")
    public String login(Info info, String name, String pwd) throws Exception{
        System.out.println(info.toString());
        System.out.println(name+"~~"+pwd);
        return "index";
    }

    // 删除用户
    // 地址栏传递信息
    // http://127.0.0.1:8256/film_system/test/admin/del/1
    @RequestMapping("/admin/del/{id}")
    public String del(@PathVariable("id")int id) throws Exception {
        System.out.println("id:"+id);
        return "index";
    }

    // 接收 Json 数据
    @RequestMapping("/rqJson1")
    @ResponseBody
    public String rqJson1(@RequestBody Info info) throws Exception {
        System.out.println(info.toString());
        return "ok";
    }

    // http://127.0.0.1:8256/film_system/test/findFilm/What
    @RequestMapping("/findFilm/{keyWord}")
    @ResponseBody
    public ResultDTO<Info> findSomeFilm(@PathVariable("keyWord")String keyWord) throws Exception {
        return infoService.findInfoByKeyWord(keyWord);
    }
}
