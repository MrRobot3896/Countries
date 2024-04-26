package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class HaversineDistance implements IDistanceCalculator {

	@Override
	public Double calculate(Double[] longlat1, Double[] longlat2) {
		double lon1Rad = Math.toRadians(longlat1[0]);
		double lat1Rad = Math.toRadians(longlat1[1]);
		double lon2Rad = Math.toRadians(longlat2[0]);
		double lat2Rad = Math.toRadians(longlat2[1]);
		double dLon = lon2Rad - lon1Rad;
        double dLat = lat2Rad - lat1Rad;
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                   Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                   Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double R = 6371;
        double distanceKm = R * c;
        // Convert kilometers to miles
        double distanceMiles = distanceKm * 0.621371;
        
        return distanceMiles;
	}

}
