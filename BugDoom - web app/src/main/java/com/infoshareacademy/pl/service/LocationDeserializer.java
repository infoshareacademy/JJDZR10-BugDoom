package com.infoshareacademy.pl.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.infoshareacademy.pl.model.Location;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class LocationDeserializer extends JsonDeserializer<Location> {

    @Override
    public Location deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String coordinates = jsonParser.getValueAsString();
        String[] latLng = coordinates.trim().split("\\s+");

        if (latLng.length == 2) {
            double longitude = Double.parseDouble(latLng[0]);
            double latitude = Double.parseDouble(latLng[1]);

            Location location = new Location();
            location.setLongitude(longitude);
            location.setLatitude(latitude);

            return location;
        }

        return null; // Możesz zwrócić null lub rzucać wyjątek w przypadku nieprawidłowych danych
    }
}