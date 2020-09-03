package edu.seu.film_system.service;

import edu.seu.film_system.mapper.UserMapper;
import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public ResultDTO<User> findAllUser() {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        resultDTO.setData(userMapper.findAllUser());
        resultDTO.setCode(20);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<User> findUserById(int userId) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        resultDTO.setData(userMapper.findUserById(userId));
        resultDTO.setCode(20);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<User> findUserByNickname(String nickname) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        List<User> list = new ArrayList<>();
        if (nickname.isEmpty()) {
            resultDTO.setCode(31);
            resultDTO.setMsg("Search in nickname: nickname cannot be empty");
        } else {
            nickname = '%' + nickname +'%';
            try {
                list = userMapper.findUserByNickname(nickname);
                resultDTO.setCode(20);
                resultDTO.setMsg("Search in nickname: Success");
            } catch (Exception e) {
                resultDTO.setCode(11);
                resultDTO.setMsg("Search in nickname: Database error");
            }
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public ResultDTO<User> loginById(int userId, String pwd) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        List<User> list = new ArrayList<>();
        if (userId == 0) {
            resultDTO.setCode(31);
            resultDTO.setMsg("Login by ID: ID cannot be 0");
        } else {
            try {
                list = userMapper.findUserById(userId);
                if (list.size() == 1) {
                    list = userMapper.loginById(userId, pwd);
                    if (list.size() == 1){
                        resultDTO.setCode(20);
                        resultDTO.setMsg("Login by ID: Success");
                    } else if (list.size() == 0) {
                        resultDTO.setCode(22);
                        resultDTO.setMsg("Login by ID: Password incorrect");
                    } else {
                        resultDTO.setCode(12);
                        resultDTO.setMsg("Login by ID: Impossible");
                    }

                } else if (list.size() == 0) {
                    resultDTO.setCode(21);
                    resultDTO.setMsg("Login by ID: ID not exist");
                } else {
                    resultDTO.setCode(12);
                    resultDTO.setMsg("Login by ID: Database has more than 1 ID");
                }
            } catch (Exception e) {
                resultDTO.setCode(11);
                resultDTO.setMsg("Login by ID: Database error");
            }
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public ResultDTO<User> loginByNickname(String nickname, String pwd) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        List<User> list = new ArrayList<>();
        if (nickname.isEmpty()) {
            resultDTO.setCode(31);
            resultDTO.setMsg("Login by nickname: nickname cannot be empty");
        } else {
            try {
                list = userMapper.findUserByNickname(nickname);
                if (list.size() == 1) {
                    list = userMapper.loginByNickname(nickname, pwd);
                    if (list.size() == 1){
                        resultDTO.setCode(20);
                        resultDTO.setMsg("Login by nickname: Success");
                    } else if (list.size() == 0) {
                        resultDTO.setCode(22);
                        resultDTO.setMsg("Login by nickname: Password incorrect");
                    } else {
                        resultDTO.setCode(12);
                        resultDTO.setMsg("Login by nickname: Impossible");
                    }

                } else if (list.size() == 0) {
                    resultDTO.setCode(21);
                    resultDTO.setMsg("Login by nickname: Nickname not exist");
                } else {
                    resultDTO.setCode(12);
                    resultDTO.setMsg("Login by nickname: Database has more than 1 nickname");
                }
            } catch (Exception e) {
                resultDTO.setCode(11);
                resultDTO.setMsg("Login by nickname: Database error");
            }
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public void newUser(User user) {
        userMapper.newUser(user.getNickname(), user.getBirthday(), user.getPwd());
    }

    @Override
    public ResultDTO<User> findUserByUser(User user) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        resultDTO.setData(userMapper.findUserByUser(user));
        resultDTO.setCode(6);
        resultDTO.setMsg("多条件查询");
        return resultDTO;
    }

    @Override
    public ResultDTO<User> addUser(User user) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        try {
            int i = userMapper.addUser(user);
            if (i > 0) {
                resultDTO.setMsg("注册成功");
            } else {
                resultDTO.setMsg("注册失败：Mapper 返回非法值");
            }
        } catch (Exception e) {
            resultDTO.setMsg("注册失败：抛出异常");
        }
        return resultDTO;
    }
}
