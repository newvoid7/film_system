package edu.seu.film_system.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class Record {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private int user_id;
    private int film_id;

    public Record() {
    }

    public Record(Date time, int user_id, int film_id) {
        this.time = time;
        this.user_id = user_id;
        this.film_id = film_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    @Override
    public String toString() {
        return "Record{" +
                "time=" + time +
                ", userId=" + user_id +
                ", filmId=" + film_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return user_id == record.user_id &&
                film_id == record.film_id &&
                time.equals(record.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, user_id, film_id);
    }
}
