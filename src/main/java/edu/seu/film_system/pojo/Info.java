package edu.seu.film_system.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Info {
    private int id;
    private String name;
    private String pwd;
    private double balance;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    public Info() {
    }

    public Info(int id, String name, String pwd, double balance) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                '}';
    }
}

