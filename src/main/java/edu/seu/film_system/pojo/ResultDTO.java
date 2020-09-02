package edu.seu.film_system.pojo;

import java.util.List;

public class ResultDTO<T> {

    private int code = 0;       // 存储状态码
    private String msg = "";    // 存储信息
    private List<T> data;       // 存储需要返回的数据

    public ResultDTO() {
    }

    public ResultDTO(int code, String msg, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
