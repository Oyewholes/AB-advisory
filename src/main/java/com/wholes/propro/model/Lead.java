package com.wholes.propro.model;

import java.time.Instant;

public class Lead {
    private final Long id;
    private final String name;
    private final String email;
    private final String phone;
    private final String service;
    private final String message;
    private final Instant createdAt;
    

    public Lead(Long id, String name, String email, String phone, String service, String message, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.service = service;
        this.message = message;
        this.createdAt = createdAt;
    }
    // getters only
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getService() { return service; }
    public String getMessage() { return message; }
    public Instant getCreatedAt() { return createdAt; }
}
