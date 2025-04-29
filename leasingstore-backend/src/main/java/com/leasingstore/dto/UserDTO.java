package com.leasingstore.dto;

/**
 * Data Transfer Object for User
 */
public class UserDTO {

    private Long id;
    private String email;
    private String mobile;
    private String name;

    // Constructors, getters, setters

    public UserDTO() {}

    public UserDTO(Long id, String email, String mobile, String name) {
        this.id = id;
        this.email = email;
        this.mobile = mobile;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
