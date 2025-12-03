package com.uberlike.ride.model;

public class Driver {
    private final String id;
    private final String name;
    private Location location;
    private boolean available = true;
    private double rating = 4.5;

    public Driver(String id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    @Override
    public String toString() {
        return String.format("Driver{id=%s,name=%s,loc=%s,avail=%s}", id, name, location, available);
    }
}