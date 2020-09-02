package edu.seu.film_system.mapper;

import edu.seu.film_system.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> findAllUser();

}
