package com.uberlike.ride.model;

public class RideRequest {
    private final String riderId;
    private final Location pickup;

    public RideRequest(String riderId, Location pickup) {
        this.riderId = riderId;
        this.pickup = pickup;
    }
    public String getRiderId() { return riderId; }
    public Location getPickup() { return pickup; }
}
