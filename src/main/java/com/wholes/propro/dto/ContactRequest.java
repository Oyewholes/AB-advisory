package com.wholes.propro.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class ContactRequest {
    @NotBlank @Size(min=2, max=60)
    private String name;

    @NotBlank @Email
    private String email;

    @NotBlank @Size(min=7, max=20)
    private String phone;

    @NotBlank(message = "please select a service")
    private String service;

    @Size(max=1000)
    private String message;

    // getters/setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getService() { return service; }
    public void setService(String service) { this.service = service; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}





