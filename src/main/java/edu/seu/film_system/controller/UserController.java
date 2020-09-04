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

    // 通过 ID 查找用户，精确查询
    // http://127.0.0.1:8256/film_system/user/id=1
    @RequestMapping("/id={userId}")
    @ResponseBody
    public ResultDTO<User> findUserById(@PathVariable("userId")int userId) {
        return userService.getUserById(userId);
    }

    // 通过昵称查找用户，模糊查询
    // http://127.0.0.1:8256/film_system/user/find/nickname=AA
    @RequestMapping("/find/nickname={nickname}")
    @ResponseBody
    public ResultDTO<User> findUserByNickname(@PathVariable("nickname")String nickname) {
        return userService.findUserByNickname(nickname);
    }

    // http://127.0.0.1:8256/film_system/user/findUserByUser
    // 通过 ID 或者 nickname 查找用户（精确查询）
    @RequestMapping("/findUserByUser")
    @ResponseBody
    public ResultDTO<User> findUserByUser(@RequestBody User user) {
        return userService.findUserByUser(user);
    }

    // 新增用户
    // 要求一个 User 对象，通过 json 从前台传进
    // http://127.0.0.1:8256/film_system/user/add
    @RequestMapping("/add")
    @ResponseBody
    public ResultDTO<User> addUser(@RequestBody User user) throws Exception {
        System.out.println(user.toString());
        return userService.addUser(user);
    }

    // 更新用户信息：昵称、ID、密码除外
    // http://127.0.0.1:8256/film_system/user/update
    @RequestMapping("/update")
    @ResponseBody
    public ResultDTO<User> update(@RequestBody User user) {
        return userService.updateUser(user);
    }

    // 登录，从昵称或账号
    // 要求一个 User 对象，通过 json 从前台传进
    // 注意：要求无论昵称还是 ID ，传入的昵称/ID 都在 nickname 标签下
    // 仅当返回 code = 201（从昵称登录） 或 202（从ID登录） 时，登录成功
    // http://127.0.0.1:8256/film_system/user/login
    @RequestMapping("/login")
    @ResponseBody
    public ResultDTO<User> login(@RequestBody User user) {
        // System.out.println(user.toString());
        String sIdOrNickname = user.getNickname();
        int iIdOrNickname = 0;
        try {
            iIdOrNickname = Integer.parseInt(sIdOrNickname);    // 尝试解析是否为 int 型的 ID
        } catch (Exception e) {
            iIdOrNickname = 0;
        }
        ResultDTO<User> resultDTO1 = userService.loginByNickname(sIdOrNickname, user.getPwd());
        ResultDTO<User> resultDTO2 = userService.loginById(iIdOrNickname, user.getPwd());
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
            resultDTO.setMsg("Login: Fail, password incorrect");
            resultDTO.setData(resultDTO1.getData());
        } else if (resultDTO1.getCode() == 21 && resultDTO2.getCode() == 21) {
            resultDTO.setCode(21);
            resultDTO.setMsg("Login: Fail, neither ID or nickname exists");
            resultDTO.setData(resultDTO1.getData());
        } else if (resultDTO1.getCode() >= 30 || resultDTO2.getCode() >= 30) {
            resultDTO.setCode(31);
            resultDTO.setMsg("Login: Fail, input error");
            resultDTO.setData(resultDTO1.getData());
        } else {
            resultDTO.setCode(11);
            resultDTO.setMsg("Login: Database error");
            resultDTO.setData(resultDTO1.getData());
        }
        return resultDTO;
    }

    // 检查昵称唯一性
    // restful 风格地址栏传值
    // http://127.0.0.1:8256/film_system/user/checkNickname/nickname=AAA
    // 仅当返回值为 20 时，昵称可用
    @RequestMapping("/checkNickname/nickname={nickname}")
    @ResponseBody
    public int checkNicknameAvailable(@PathVariable("nickname")String nickname) throws Exception {
        return userService.checkNicknameAvailable(nickname);
    }

    // 更新用户昵称
    // TODO 用 xml 中的函数？还是直接传入 json
}

