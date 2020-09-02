package edu.seu.film_system.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    private int id;
    private String pwd;
    private String nickname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public User(int id, String pwd, String nickname, Date birthday) {
        this.id = id;
        this.pwd = pwd;
        this.nickname = nickname;
        this.birthday = birthday;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", nickName='" + nickname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
