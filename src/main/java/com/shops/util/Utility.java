package com.shops.util;

/**
 *
 * @author Shilpa
 * Utility class
 */
public class Utility {

    /**
     * Earth’s radius in kilometers
     */
    private static Double EARTH_RADIUS = 6371.00; // Radius in Kilometers default

    /**
     * Haversine formula to calculate the Great-circle distance between two
     * points on a sphere from their longitudes and latitudes
     *
     * a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2) c = 2 ⋅ atan2( √a, √(1−a) )
     * d = R ⋅ c
     *
     * where φ is latitude, λ is longitude, R is earth’s radius (mean radius =
     * 6,371km) note that angles need to be in radians
     *
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @return Great-circle distance in kilometers
     */

    public static Double calculateDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
        Double Radius = Utility.EARTH_RADIUS; //6371.00;
        Double dLat = Utility.toRadians(lat2 - lat1);
        Double dLon = Utility.toRadians(lon2 - lon1);
        Double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Utility.toRadians(lat1)) * Math.cos(Utility.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        Double c = 2 * Math.asin(Math.sqrt(a));
        return Radius * c;
    }

    public static Double toRadians(Double degree) {
        // Value degree * Pi/180
        Double res = degree * 3.1415926 / 180;
        return res;
    }
}
