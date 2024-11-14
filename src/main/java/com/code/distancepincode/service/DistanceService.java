package com.code.distancepincode.service;

import com.code.distancepincode.entity.DistanceInfo;
import com.code.distancepincode.repository.DistanceInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class DistanceService {

    @Autowired
    private DistanceInfoRepository distanceInfoRepository;

    private final String GOOGLE_MAPS_API_URL = "https://maps.googleapis.com/maps/api/directions/json?origin=%s&destination=%s&key=YOUR_API_KEY";

    public DistanceInfo getDistanceAndDuration(String fromPincode, String toPincode) {
        // Check if the data is already cached
        DistanceInfo cachedInfo = distanceInfoRepository.findByFromPincodeAndToPincode(fromPincode, toPincode);
        if (cachedInfo != null) {
            return cachedInfo;
        }

        // Fetch data from Google Maps API
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(GOOGLE_MAPS_API_URL, fromPincode, toPincode);
        GoogleMapsResponse response = restTemplate.getForObject(url, GoogleMapsResponse.class);

        // Process the response
        if (response != null && response.getRoutes() != null && !response.getRoutes().isEmpty()) {
            String distance = response.getRoutes().get(0).getLegs().get(0).getDistance().getText();
            String duration = response.getRoutes().get(0).getLegs().get(0).getDuration().getText();
            List<String> routes = Arrays.asList(response.getRoutes().get(0).getSummary());

            // Save to database
            DistanceInfo distanceInfo = new DistanceInfo();
            distanceInfo.setFromPincode(fromPincode);
            distanceInfo.setToPincode(toPincode);
            distanceInfo.setDistance(distance);
            distanceInfo.setDuration(duration);
            distanceInfo.setRoutes(routes);
            distanceInfoRepository.save(distanceInfo);

            return distanceInfo;
        }

        return null;
    }
}