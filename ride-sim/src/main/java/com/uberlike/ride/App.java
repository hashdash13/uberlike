package com.uberlike.ride;

import com.uberlike.ride.model.Driver;
import com.uberlike.ride.model.Location;
import com.uberlike.ride.model.RideRequest;
import com.uberlike.ride.service.DriverRegistry;
import com.uberlike.ride.service.RideMatcher;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class App {
    public static void main(String[] args) {
        DriverRegistry registry = new DriverRegistry();
        RideMatcher matcher = new RideMatcher(registry);

        registry.addDriver(new Driver("d1", "Anita", new Location(28.6139,77.2090))); // Delhi
        registry.addDriver(new Driver("d2", "Ravi", new Location(28.7041,77.1025)));
        registry.addDriver(new Driver("d3", "Sara", new Location(28.5355,77.3910)));

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rider lat lon (e.g. 28.6 77.2):");
        double lat = sc.nextDouble();
        double lon = sc.nextDouble();

        RideRequest req = new RideRequest(UUID.randomUUID().toString(), new Location(lat, lon));
        Optional<Driver> driver = matcher.findNearestDriver(req);

        if (driver.isPresent()) {
            System.out.println("Assigned driver: " + driver.get());
            driver.get().setAvailable(false); // mark as busy
        } else {
            System.out.println("No available drivers found.");
        }
        sc.close();
    }
}
