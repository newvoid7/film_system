package edu.seu.film_system.pojo;

import java.time.Year;
import java.util.Objects;

public class Film {
    private String name;
    private int id;
    private int duration;
    private String summary;
    private String videoUrl;
    private String imageUrl;
    private int viewCount;
    private String tag;
    private Year year;

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", duration=" + duration +
                ", summary='" + summary + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", viewCount=" + viewCount +
                ", tag='" + tag + '\'' +
                ", year=" + year +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public Film() {
    }

    public Film(String name, int id, int duration, String summary, String videoUrl, String imageUrl, int viewCount, String tag, Year year) {
        this.name = name;
        this.id = id;
        this.duration = duration;
        this.summary = summary;
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
        this.viewCount = viewCount;
        this.tag = tag;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
