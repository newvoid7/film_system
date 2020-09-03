package edu.seu.film_system.controller;

import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.pojo.User;
import edu.seu.film_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    // http://127.0.0.1:8256/film_system/user/all
    // 搜索出所有用户（仅测试）
    @RequestMapping("/all")
    @ResponseBody
    public ResultDTO<User> findAll() throws Exception {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        resultDTO=userService.findAllUser();
        // System.out.println(resultDTO.getData());
        return resultDTO;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public ResultDTO<User> addUser(@RequestBody User user) throws Exception {
        System.out.println(user.toString());
        return userService.addUser(user);
    }
}

