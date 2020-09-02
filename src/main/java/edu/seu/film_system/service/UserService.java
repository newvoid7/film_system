package edu.seu.film_system.service;

import edu.seu.film_system.pojo.ResultDTO;
import edu.seu.film_system.pojo.User;

public interface UserService {
    ResultDTO<User> findAllUser();
}
