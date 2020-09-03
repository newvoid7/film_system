package edu.seu.film_system.mapper;

import edu.seu.film_system.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> findAllUser();

    @Select("SELECT * FROM user WHERE id = ${userId}")
    List<User> findUserById(@Param("userId") int userId);

    @Select("SELECT * FROM user WHERE nickname LIKE '${nickname}'")
    List<User> findUserByNickname(@Param("nickname") String nickname);

    @Select("SELECT * FROM user WHERE nickname = '${nickname}' AND pwd = '${pwd}'")
    List<User> loginByNickname(@Param("nickname")String nickname, @Param("pwd")String pwd);

    @Select("SELECT * FROM user WHERE id = ${userId} AND pwd = '${pwd}'")
    List<User> loginById(@Param("userId")int userId, @Param("pwd")String pwd);

    @Update("UPDATE user SET nickname = '${newNickname}' WHERE id = ${userId}")
    int updateNickname(@Param("newNickname")String newNickname, @Param("userId")int userId);

    @Update("UPDATE user SET birthday = '${newBirthday}' WHERE id = ${userId}")
    int updateBirthday(@Param("newBirthday")Date newBirthday, @Param("userId")int userId);

    // 根据 User 查询信息
    List<User> findUserByUser(User user);

    // INSERT
    int addUser(User user);

    // UPDATE
    int updateNickname(User user);

    @Insert("INSERT INTO user (nickname, birthday, pwd) VALUES ('${nickname}', ${birthday}, '${pwd}')")
    void newUser(@Param("nickname")String nickname, @Param("birthday")Date birthday, @Param("pwd")String pwd);
}
