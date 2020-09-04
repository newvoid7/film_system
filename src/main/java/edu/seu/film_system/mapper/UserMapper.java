package edu.seu.film_system.mapper;

import edu.seu.film_system.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> findAllUser();

    @Select("SELECT * FROM user WHERE id = ${userId}")
    List<User> getUserById(@Param("userId") int userId);

    @Select("SELECT * FROM user WHERE nickname LIKE '${nickname}'")
    List<User> findUserByNickname(@Param("nickname") String nickname);

    @Select("SELECT * FROM user WHERE nickname = '${nickname}' AND pwd = '${pwd}'")
    List<User> loginByNickname(@Param("nickname")String nickname, @Param("pwd")String pwd);

    @Select("SELECT * FROM user WHERE id = ${userId} AND pwd = '${pwd}'")
    List<User> loginById(@Param("userId")int userId, @Param("pwd")String pwd);

    // INSERT
    int addUser(User user);

    // DELETE
    // TODO
    // int deleteUser(User user);

    // UPDATE
    int updateUser(User user);

    // SELECT
    // 通过昵称或 ID
    User findUserByUser(User user);

}
