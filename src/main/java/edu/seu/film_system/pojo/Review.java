package edu.seu.film_system.pojo;

import java.util.Date;

public class Review {
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
}
