package com.uberlike.ride.service;

import com.uberlike.ride.model.Driver;
import com.uberlike.ride.model.Location;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DriverRegistry {
    private final Map<String, Driver> drivers = new ConcurrentHashMap<>();

    public void addDriver(Driver d) { drivers.put(d.getId(), d); }
    public void updateLocation(String driverId, Location loc) {
        Driver d = drivers.get(driverId);
        if (d != null) d.setLocation(loc);
    }
    public List<Driver> getAllAvailableDrivers() {
        List<Driver> res = new ArrayList<>();
        for (Driver d : drivers.values()) {
            if (d.isAvailable()) res.add(d);
        }
        return res;
    }
}
