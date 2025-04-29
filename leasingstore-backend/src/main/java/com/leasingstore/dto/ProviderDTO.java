package com.leasingstore.dto;

/**
 * Data Transfer Object for Provider
 */
public class ProviderDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private boolean verified;

    // Constructors, getters, setters

    public ProviderDTO() {}

    public ProviderDTO(Long id, String name, String email, String phone, boolean verified) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.verified = verified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
