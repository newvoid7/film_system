package edu.seu.film_system.pojo;

import java.util.Objects;

public class Favorite {
    private int user_id;        // Main Key
    private int film_id;        // Main Key

    public Favorite() {
    }

    public Favorite(int user_id, int film_id) {
        this.user_id = user_id;
        this.film_id = film_id;
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
        return "Favorite{" +
                "user_id=" + user_id +
                ", film_id=" + film_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorite favorite = (Favorite) o;
        return user_id == favorite.user_id &&
                film_id == favorite.film_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, film_id);
    }
}
