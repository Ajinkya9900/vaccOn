package com.vaccnow.sample.controller.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;


public class ClientDetailsRequest {

    @JsonProperty("Name")
    @NotBlank(message = "Name must not be empty")
    private String name;

    @JsonProperty("Email")
    @NotBlank(message = "Email must not be empty")
    private String email;

    @JsonProperty("Time Slot")
    @NotBlank(message = "Time Slot must not be empty")
    private String timeSlot;

    @JsonProperty("Payment Method")
    @NotBlank(message = "Payment Method must not be empty")
    private String paymentMethod;

    @JsonProperty("Branch Name")
    @NotBlank(message = "Branch Name must not be empty")
    private String branchName;

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

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
