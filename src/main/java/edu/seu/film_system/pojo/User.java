package edu.seu.film_system.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.Objects;

public class User {
    private int id;                         // Main Key, Auto Increase
    private String pwd;                     // Not Null
    private String nickname;                // Key, Not Null
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    // @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String avatar_url;
    private String gender;
    private String intro;

    public User(int id, String pwd, String nickname, Date birthday, String avatar_url, String gender, String intro) {
        this.id = id;
        this.pwd = pwd;
        this.nickname = nickname;
        this.birthday = birthday;
        this.avatar_url = avatar_url;
        this.gender = gender;
        this.intro = intro;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", birthday=" + birthday +
                ", avatar_url='" + avatar_url + '\'' +
                ", gender='" + gender + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void protectInfo() {
        setPwd("Masked");
    }

}
