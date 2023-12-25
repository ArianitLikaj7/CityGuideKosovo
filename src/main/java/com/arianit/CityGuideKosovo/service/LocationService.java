package com.arianit.CityGuideKosovo.service;

import com.arianit.CityGuideKosovo.entity.City;
import com.arianit.CityGuideKosovo.entity.Location;
import com.arianit.CityGuideKosovo.repository.CityRepository;
import com.arianit.CityGuideKosovo.repository.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocationService {

    private final LocationRepository locationRepository;
    private final CityRepository cityRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository, CityRepository cityRepository) {
        this.locationRepository = locationRepository;
        this.cityRepository = cityRepository;
    }

    public Location getLocationById(long locationId){
        return locationRepository.findById(locationId)
                .orElseThrow(()-> new EntityNotFoundException("Location not found with id: "+locationId));
    }
    public Location createLocationForCity(long cityId, Location location) {
        // Retrieve the city by ID
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new EntityNotFoundException("City not found with id: " + cityId));

        // Check if the location already exists with the given ID
        if (locationRepository.existsById(location.getLocationId())) {
            throw new IllegalArgumentException("The Location with this id already exists: " + location.getLocationId());
        }

        // Set the city for the location
        location.setCity(city);

        // Save the location
        return locationRepository.save(location);
    }

    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    public void deleteLocation(long locationId){
        if(!locationRepository.existsById(locationId)){
            throw new EntityNotFoundException("Location with id dosent exist "+ locationId);
        }
        locationRepository.deleteById(locationId);
    }

    public Location saveLocation(Location location){
        if(locationRepository.existsById(location.getLocationId())){
            throw new IllegalArgumentException("The Location with this id exist: "+location.getLocationId());
        }
        return locationRepository.save(location);
    }
}
