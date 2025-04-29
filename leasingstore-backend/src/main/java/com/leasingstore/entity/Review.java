package com.leasingstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

/**
 * Entity class representing a Review left by a User for a Service
 */
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating;
    private String comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Service service;

    // Constructors, getters, setters

    public Review() {}

    public Review(int rating, String comment, User user, Service service) {
        this.rating = rating;
        this.comment = comment;
        this.user = user;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
