package edu.seu.film_system.pojo;

public class Film {
    private String name;
    private int id;
    private int duration;
    private String summary;

    @Override
    public String toString() {
        return "film{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", duration=" + duration +
                ", summary='" + summary + '\'' +
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

    public Film() {
    }

    public Film(String name, int id, int duration, String summary) {
        this.name = name;
        this.id = id;
        this.duration = duration;
        this.summary = summary;
    }
}
