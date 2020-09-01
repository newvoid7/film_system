package edu.seu.film_system.pojo;

import java.util.Date;

public class User {
    private int id;
    private String pwd;
    private Date birthday;

    public User(int id, String pwd, Date birthday) {
        this.id = id;
        this.pwd = pwd;
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

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
