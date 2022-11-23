package com.wolf.consumer1.entity;

public class Customer {

    private String name;
    private String email;
    private boolean statusFl;

    public Customer() {
    }

    public Customer(String name, String email, boolean statusFl) {
        this.name = name;
        this.email = email;
        this.statusFl = statusFl;
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

    public boolean isStatusFl() {
        return statusFl;
    }

    public void setStatusFl(boolean statusFl) {
        this.statusFl = statusFl;
    }
}
