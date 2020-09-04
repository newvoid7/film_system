package edu.seu.film_system.service;

import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.pojo.User;

import java.util.Date;

public interface UserService {
    ResultDTO<User> findAllUser();
    ResultDTO<User> findUserById(int userId);
    ResultDTO<User> findUserByNickname(String nickname);
    ResultDTO<User> loginById(int userId, String pwd);
    ResultDTO<User> loginByNickname(String nickname, String pwd);
    ResultDTO<User> addUser(User user);
    ResultDTO<User> delUser(User user);
    ResultDTO<User> updateUser(User user);
    ResultDTO<User> findUserByUser(User user);
    int checkNicknameAvailable(String nickname);
}
