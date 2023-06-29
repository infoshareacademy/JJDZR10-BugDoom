package com.infoshareacademy.pl.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.pl.model.Location;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class LocationConverter {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public List<Location> convert(String source) {
        List<Location> locations = new ArrayList<>();

        try {
            String[] coordinates = source.split(",");
            for (String coordinate : coordinates) {
                String[] latLng = coordinate.trim().split("\\s+");
                if (latLng.length == 2) {
                    double longitude = Double.parseDouble(latLng[0]);
                    double latitude = Double.parseDouble(latLng[1]);

                    Location location = new Location();
                    location.setLongitude(longitude);
                    location.setLatitude(latitude);

                    locations.add(location);
                }
            }
        } catch (Exception e) {
            // Obsługa błędu parsowania JSON
        }

        return locations;
    }

    public List<Location> convertFromJson(String json) {
        try {
            return Arrays.asList(objectMapper.readValue(json, Location[].class));
        } catch (Exception e) {
            // Obsługa błędu parsowania JSON
            return new ArrayList<>();
        }
    }

    public String convertToJson(List<Location> locations) {
        try {
            return objectMapper.writeValueAsString(locations);
        } catch (Exception e) {
            // Obsługa błędu konwersji do JSON
            return "";
        }
    }
}