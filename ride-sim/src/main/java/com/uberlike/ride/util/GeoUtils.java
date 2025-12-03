package com.uberlike.ride.util;

import com.uberlike.ride.model.Location;

public class GeoUtils {
    
    public static double haversineKm(Location a, Location b) {
        double R = 6371;
        double lat1 = Math.toRadians(a.getLat());
        double lat2 = Math.toRadians(b.getLat());
        double dLat = lat2 - lat1;
        double dLon = Math.toRadians(b.getLon() - a.getLon());

        double sinDlat = Math.sin(dLat/2);
        double sinDlon = Math.sin(dLon/2);
        double val = sinDlat*sinDlat + Math.cos(lat1) * Math.cos(lat2) * sinDlon*sinDlon;
        double c = 2 * Math.atan2(Math.sqrt(val), Math.sqrt(1-val));
        return R * c;
    }
}
