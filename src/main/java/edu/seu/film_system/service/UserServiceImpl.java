package edu.seu.film_system.service;

import edu.seu.film_system.mapper.UserMapper;
import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public ResultDTO<User> findAllUser() {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        resultDTO.setData(userMapper.findAllUser());
        resultDTO.setCode(1);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<User> findUserById(int userId) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        resultDTO.setData(userMapper.findUserById(userId));
        resultDTO.setCode(1);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<User> findUserByNickname(String nickname) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        resultDTO.setData(userMapper.findUserByNickname(nickname));
        resultDTO.setCode(1);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public void newUser(User user) {
        userMapper.newUser(user.getNickname(), user.getBirthday(), user.getPwd());
    }
}
