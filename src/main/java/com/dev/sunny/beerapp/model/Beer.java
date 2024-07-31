package com.dev.sunny.beerapp.model;

public class Beer {
    private int id;
    private String name;
    private float price;
    private boolean availability;

    public Beer(int id, String name, float price, boolean availability) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailable(boolean availability) {
        this.availability = availability;
    }
}
