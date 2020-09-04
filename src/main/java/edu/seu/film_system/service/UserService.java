package edu.seu.film_system.service;

import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.pojo.User;

public interface UserService {
    ResultDTO<User> findAllUser();
    ResultDTO<User> getUserById(int userId);
    ResultDTO<User> findUserByNickname(String nickname);
    ResultDTO<User> loginById(int userId, String pwd);
    ResultDTO<User> loginByNickname(String nickname, String pwd);
    ResultDTO<User> addUser(User user);
    ResultDTO<User> delUser(User user);
    ResultDTO<User> updateUser(User user);
    ResultDTO<User> findUserByUser(User user);
    int updatePwd(String newNickname, int userId);
    int checkNicknameAvailable(String nickname);
}
