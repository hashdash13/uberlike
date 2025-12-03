package com.uberlike.ride.service;

import com.uberlike.ride.model.Driver;
import com.uberlike.ride.model.RideRequest;
import com.uberlike.ride.util.GeoUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

public class RideMatcher {

    private final DriverRegistry registry;

    public RideMatcher(DriverRegistry registry) {
        this.registry = registry;
    }

    public Optional<Driver> findNearestDriver(RideRequest req) {
        List<Driver> candidates = registry.getAllAvailableDrivers();
        if (candidates.isEmpty()) return Optional.empty();

        PriorityQueue<Driver> pq = new PriorityQueue<>(Comparator.comparingDouble(
                d -> score(d, req)
        ));

        for (Driver d : candidates) pq.offer(d);

        return Optional.ofNullable(pq.poll());
    }

    // Lower score = better candidate
    private double score(Driver d, RideRequest req) {
        double distKm = GeoUtils.haversineKm(d.getLocation(), req.getPickup());
        // score can include rating influence (higher rating -> lower score)
        double ratingFactor = (5.0 - d.getRating()) * 0.1; // small influence
        return distKm + ratingFactor;
    }
}
