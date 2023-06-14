package com.infoshareacademy.pl.service;

import com.infoshareacademy.pl.model.Location;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LocationService {
        private List<Location> checkpoints = new ArrayList<>();

        public List<Location> getAll() {
            return checkpoints;
        }

        public void addLocation(Location checkpointsToAdd) {
            checkpoints.add(checkpointsToAdd);
        }
}
