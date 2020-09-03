package edu.seu.film_system.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class Review {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private int userId;
    private int filmId;
    private String content;

    public Review(Date time, int userId, int filmId, String content) {
        this.time = time;
        this.userId = userId;
        this.filmId = filmId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
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
                ", userId=" + userId +
                ", filmId=" + filmId +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return userId == review.userId &&
                filmId == review.filmId &&
                time.equals(review.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, userId, filmId);
    }
}
