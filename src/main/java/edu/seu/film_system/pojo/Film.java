package edu.seu.film_system.pojo;

public class Film {
    private String name;
    private int id;
    private int duration;
    private String summary;
    private String videoUrl;
    private String imageUrl;
    private int viewCount;

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

    public Film(String name, int id, int duration, String summary, String videoUrl, String imageUrl, int viewCount) {
        this.name = name;
        this.id = id;
        this.duration = duration;
        this.summary = summary;
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
        this.viewCount = viewCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Film)){
            return false;
        }
        else {
            Film f = (Film) obj;
            return this.id==f.id;
        }
    }

    @Override
    public int hashCode() {
        return id;
    }
}
