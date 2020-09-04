package edu.seu.film_system.pojo;

public class ReviewAndUser {
    private Review review;
    private User user;

    public ReviewAndUser() {
    }

    public ReviewAndUser(Review review, User user) {
        this.review = review;
        this.user = user;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
