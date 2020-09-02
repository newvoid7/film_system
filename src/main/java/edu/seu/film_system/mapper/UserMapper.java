package edu.seu.film_system.mapper;

import edu.seu.film_system.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> findAllUser();

    @Select("SELECT * FROM user WHERE id = ${userId}")
    List<User> findUserById(@Param("userId") int userId);

    @Select("SELECT * FROM user WHERE nickname LIKE ${nickname}")
    List<User> findUserByNickname(@Param("nickname") String nickname);

    @Insert("INSERT INTO user (nickname, birthday, pwd) VALUES ('${nickname}', ${birthday}, '${pwd}')")
    void newUser(@Param("nickname")String nickname, @Param("birthday")Date birthday, @Param("pwd")String pwd);
}
