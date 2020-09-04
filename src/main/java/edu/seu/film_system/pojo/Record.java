package edu.seu.film_system.pojo;

import java.util.Objects;

public class Record {

    private int user_id;            // 用户 ID, Main Key
    private int film_id;            // 电影 ID, Main Key
    private int last_timestamp;     // 上次浏览位置，单位（毫秒？）

    public Record() {
    }

    public Record(int user_id, int film_id, int last_timestamp) {
        this.user_id = user_id;
        this.film_id = film_id;
        this.last_timestamp = last_timestamp;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getLast_timestamp() {
        return last_timestamp;
    }

    public void setLast_timestamp(int last_timestamp) {
        this.last_timestamp = last_timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return user_id == record.user_id &&
                film_id == record.film_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, film_id);
    }

    @Override
    public String toString() {
        return "Record{" +
                "user_id=" + user_id +
                ", film_id=" + film_id +
                ", last_timestamp=" + last_timestamp +
                '}';
    }
}
