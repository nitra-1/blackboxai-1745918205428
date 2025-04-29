package com.leasingstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * Entity class representing an Inquiry made by a User to a Provider about a Service
 */
@Entity
public class Inquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime inquiryDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Provider provider;

    @ManyToOne
    private Service service;

    private String message;

    // Constructors, getters, setters

    public Inquiry() {}

    public Inquiry(LocalDateTime inquiryDate, User user, Provider provider, Service service, String message) {
        this.inquiryDate = inquiryDate;
        this.user = user;
        this.provider = provider;
        this.service = service;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(LocalDateTime inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
