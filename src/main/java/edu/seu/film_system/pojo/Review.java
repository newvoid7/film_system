package edu.seu.film_system.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.Objects;

public class Review {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private int user_id;
    private int film_id;
    private String content;

    public Review(Date time, int user_id, int film_id, String content) {
        this.time = time;
        this.user_id = user_id;
        this.film_id = film_id;
        this.content = content;
    }

    public Review() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Review{" +
                "time=" + time +
                ", userId=" + user_id +
                ", filmId=" + film_id +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return user_id == review.user_id &&
                film_id == review.film_id &&
                time.equals(review.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, user_id, film_id);
    }
}
