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

import java.util.List;

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

    @RequestMapping("/login")
    @ResponseBody
    public ResultDTO<User> login(@RequestBody User user) {
        ResultDTO<User> resultDTO1 = userService.loginByNickname(user.getNickname(), user.getPwd());
        ResultDTO<User> resultDTO2 = userService.loginById(user.getId(), user.getPwd());
        ResultDTO<User> resultDTO = new ResultDTO<>();
        if (resultDTO1.getCode() == 20) {
            resultDTO.setCode(201);
            resultDTO.setMsg("Login: Success logged in by nickname");
            resultDTO.setData(resultDTO1.getData());
        } else if (resultDTO2.getCode() == 20) {
            resultDTO.setCode(202);
            resultDTO.setMsg("Login: Success logged in by id");
            resultDTO.setData(resultDTO2.getData());
        } else if (resultDTO1.getCode() == 22 || resultDTO2.getCode() == 22) {
            resultDTO.setCode(22);
            resultDTO.setMsg("Login: Password incorrect");
            resultDTO.setData(resultDTO1.getData());
        } else if (resultDTO1.getCode() == 21 && resultDTO2.getCode() == 21) {
            resultDTO.setCode(21);
            resultDTO.setMsg("Login: ID and nickname neither exist");
            resultDTO.setData(resultDTO1.getData());
        }
        return resultDTO;
    }
}

