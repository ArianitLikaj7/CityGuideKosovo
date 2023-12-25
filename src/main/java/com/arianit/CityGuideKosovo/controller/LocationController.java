package com.arianit.CityGuideKosovo.controller;

import com.arianit.CityGuideKosovo.entity.Location;
import com.arianit.CityGuideKosovo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<Location> getLocationById(@PathVariable long locationId) {
        Location location = locationService.getLocationById(locationId);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationService.getAllLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @PostMapping("/createForCity/{cityId}")
    public ResponseEntity<Location> createLocationForCity(
            @PathVariable long cityId,
            @RequestBody Location location) {
        Location createdLocation = locationService.createLocationForCity(cityId, location);
        return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<String> deleteLocation(@PathVariable long locationId) {
        locationService.deleteLocation(locationId);
        return new ResponseEntity<>("Location deleted successfully", HttpStatus.NO_CONTENT);
    }
}
