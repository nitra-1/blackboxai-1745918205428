package com.leasingstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

/**
 * Entity class representing a Service offered by a Provider
 */
@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private double pricePerDay;
    private double pricePerHour;
    private double pricePerMonth;
    private String availabilityCalendar; // Could be JSON or other format

    @ManyToOne
    private Provider provider;

    // Constructors, getters, setters

    public Service() {}

    public Service(String title, String description, String category, double pricePerDay, double pricePerHour, double pricePerMonth, String availabilityCalendar, Provider provider) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.pricePerMonth = pricePerMonth;
        this.availabilityCalendar = availabilityCalendar;
        this.provider = provider;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public String getAvailabilityCalendar() {
        return availabilityCalendar;
    }

    public void setAvailabilityCalendar(String availabilityCalendar) {
        this.availabilityCalendar = availabilityCalendar;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
