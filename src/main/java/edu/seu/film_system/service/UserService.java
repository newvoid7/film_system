package edu.seu.film_system.service;

import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.pojo.User;

import java.util.Date;

public interface UserService {
    ResultDTO<User> findAllUser();
    ResultDTO<User> findUserById(int userId);
    ResultDTO<User> findUserByNickname(String nickname);
    void newUser(User user);
}
