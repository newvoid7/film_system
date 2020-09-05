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

    // 找出所有用户（仅测试）
    @Override
    public ResultDTO<User> findAllUser() {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        List<User> list = new ArrayList<>();
        try {
            list = userMapper.findAllUser();
            for (int i = 0; i < list.size(); ++i) {            // 保护密码信息
                list.get(i).protectInfo();
            }
            resultDTO.setCode(20);
            resultDTO.setMsg("Find all user: Success");
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find all user: Database");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    // 通过 ID 查找用户（登录后），精确查询
    @Override
    public ResultDTO<User> getUserById(int userId) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        List<User> list = new ArrayList<>();
        try {
            list = userMapper.getUserById(userId);
            for (int i = 0; i < list.size(); ++i) {            // 保护密码信息
                list.get(i).protectInfo();
            }
            if (list.isEmpty()) {
                resultDTO.setCode(21);
                resultDTO.setMsg("Find user by id: Success but no data");
            } else {
                resultDTO.setCode(20);
                resultDTO.setMsg("Find user by id: Success");
            }
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find user by id: Database");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    // 通过昵称查找用户（登录后），模糊查询
    @Override
    public ResultDTO<User> findUserByNickname(String nickname) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        List<User> list = new ArrayList<>();
        if (nickname == null || nickname.isEmpty()) {       // 有可能为空
            resultDTO.setCode(31);
            resultDTO.setMsg("Search in nickname: nickname cannot be empty");
        } else {
            nickname = '%' + nickname +'%';
            try {
                list = userMapper.findUserByNickname(nickname);
                for (int i = 0; i < list.size(); ++i) {            // 保护密码信息
                    list.get(i).protectInfo();
                }
                if (list.isEmpty()) {
                    resultDTO.setCode(21);
                    resultDTO.setMsg("Search by nickname: Success but no data");
                } else {
                    resultDTO.setCode(20);
                    resultDTO.setMsg("Search by nickname: Success");
                }
            } catch (Exception e) {
                resultDTO.setCode(11);
                resultDTO.setMsg("Search by nickname: Database error");
            }
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    // 通过 ID 登录，精确查询
    @Override
    public ResultDTO<User> loginById(int userId, String pwd) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        List<User> list = new ArrayList<>();
        if (userId == 0) {
            resultDTO.setCode(31);
            resultDTO.setMsg("Login by ID: ID cannot be 0");
        } else {
            try {
                list = userMapper.getUserById(userId);
                if (list.size() == 1) {
                    list = userMapper.loginById(userId, pwd);
                    if (list.size() == 1){
                        list.get(0).protectInfo();
                        resultDTO.setCode(20);
                        resultDTO.setMsg("Login by ID: Success");
                    } else if (list.size() == 0) {
                        resultDTO.setCode(22);
                        resultDTO.setMsg("Login by ID: Password incorrect");
                    } else {
                        list.clear();
                        resultDTO.setCode(12);
                        resultDTO.setMsg("Login by ID: Impossible");
                    }
                } else if (list.size() == 0) {
                    resultDTO.setCode(21);
                    resultDTO.setMsg("Login by ID: ID not exist");
                } else {
                    list.clear();
                    resultDTO.setCode(12);
                    resultDTO.setMsg("Login by ID: Database has more than 1 ID");
                }
            } catch (Exception e) {
                list.clear();
                resultDTO.setCode(11);
                resultDTO.setMsg("Login by ID: Database error");
            }
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    // 通过昵称登录，精确查询
    @Override
    public ResultDTO<User> loginByNickname(String nickname, String pwd) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        List<User> list = new ArrayList<>();
        if (nickname == null || nickname.isEmpty()) {
            resultDTO.setCode(31);
            resultDTO.setMsg("Login by nickname: nickname cannot be empty");
        } else {
            try {
                list = userMapper.findUserByNickname(nickname);
                if (list.size() == 1) {
                    list = userMapper.loginByNickname(nickname, pwd);
                    if (list.size() == 1){
                        list.get(0).protectInfo();
                        resultDTO.setCode(20);
                        resultDTO.setMsg("Login by nickname: Success");
                    } else if (list.size() == 0) {
                        resultDTO.setCode(22);
                        resultDTO.setMsg("Login by nickname: Password incorrect");
                    } else {
                        list.clear();
                        resultDTO.setCode(12);
                        resultDTO.setMsg("Login by nickname: Impossible");
                    }

                } else if (list.size() == 0) {
                    resultDTO.setCode(21);
                    resultDTO.setMsg("Login by nickname: Nickname not exist");
                } else {
                    list.clear();
                    resultDTO.setCode(12);
                    resultDTO.setMsg("Login by nickname: Database has more than 1 nickname");
                }
            } catch (Exception e) {
                list.clear();
                resultDTO.setCode(11);
                resultDTO.setMsg("Login by nickname: Database error");
            }
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    // 用户注册
    // 使用了 xml 中定义的 mapper
    @Override
    public ResultDTO<User> addUser(User user) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        List<User> list = new ArrayList<>();
        try {
            int code = userMapper.addUser(user);
            if (code > 0) {
                User newUser = userMapper.findUserByUser(user);
                newUser.protectInfo();                  // 保护信息
                list.add(newUser);                      // 返回刚刚注册的用户对象
                resultDTO.setCode(20);
                resultDTO.setMsg("Add user: Success");
            } else {
                resultDTO.setCode(12);
                resultDTO.setMsg("Add user: Fail. Maybe nickname not unique");
            }
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Add user: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    // TODO
    @Override
    public ResultDTO<User> delUser(User user) {
        return null;
    }

    @Override
    public ResultDTO<User> updateUser(User user) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        List<User> list = new ArrayList<>();
        try {
            int code = userMapper.updateUser(user);
            if (code > 0) {
                User newUser = userMapper.findUserByUser(user);
                newUser.protectInfo();                  // 保护信息
                list.add(newUser);                      // 返回刚刚更新的用户对象
                resultDTO.setCode(20);
                resultDTO.setMsg("Update user: Success");
            } else {
                resultDTO.setCode(12);
                resultDTO.setMsg("Update user: Fail");
            }
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Update user: Database error");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    // 用户多条件查询
    // 通过昵称或 ID
    @Override
    public ResultDTO<User> findUserByUser(User user) {
        ResultDTO<User> resultDTO = new ResultDTO<>();
        List<User> list = new ArrayList<>();
        User resultUser = new User();
        try {
            resultUser = userMapper.findUserByUser(user);
            if (resultUser == null) {
                resultDTO.setCode(21);
                resultDTO.setMsg("Find user by user: Success but no data");
            } else {
                list.add(resultUser);
                resultDTO.setCode(20);
                resultDTO.setMsg("Find user by user: Success");
            }
        } catch (Exception e) {
            resultDTO.setCode(11);
            resultDTO.setMsg("Find user by user: Database error, maybe nickname or ID not unique");
        }
        resultDTO.setData(list);
        return resultDTO;
    }

    @Override
    public int updatePwd(String newNickname, int userId) {
        return 0;
    }

    // 检查昵称唯一性
    @Override
    public int checkNicknameAvailable(String nickname) {
        int code = 0;
        if (nickname == null || nickname.isEmpty()) {
            code = 11;                      // 输入参数有误
        } else {
            try {
                List<User> list = new ArrayList<>();
                list = userMapper.findUserByNickname(nickname);
                if (list.isEmpty()) {
                    code = 20;              // 查询昵称未注册
                } else {
                    code = 21;              // 查询昵称已注册
                }
            } catch (Exception e) {
                code = 31;                  // 数据库错误
            }
        }
        return code;
    }
}
