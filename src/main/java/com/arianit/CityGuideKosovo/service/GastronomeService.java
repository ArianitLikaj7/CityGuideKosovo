package com.arianit.CityGuideKosovo.service;

import com.arianit.CityGuideKosovo.entity.Gastronome;
import com.arianit.CityGuideKosovo.entity.Location;
import com.arianit.CityGuideKosovo.repository.GastronomeRepository;
import com.arianit.CityGuideKosovo.repository.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastronomeService {

    private final GastronomeRepository gastronomeRepository;
    private final LocationRepository locationRepository; // Inject the LocationRepository

    @Autowired
    public GastronomeService(GastronomeRepository gastronomeRepository, LocationRepository locationRepository) {
        this.gastronomeRepository = gastronomeRepository;
        this.locationRepository = locationRepository;
    }

    public List<Gastronome> getAllGastronom(){
        return gastronomeRepository.findAll();
    }

    public Gastronome getGastronomeById(long gastronomeId){
        return gastronomeRepository.findById(gastronomeId)
                .orElseThrow(()-> new EntityNotFoundException("Gastronome with this id dosent exist "+gastronomeId));
    }

    public void deleteGastronomeById(long gastronomeId){
        if(!gastronomeRepository.existsById(gastronomeId)){
            throw new EntityNotFoundException("Gastronome with this Id doesnt exist: "+ gastronomeId);
        }
        gastronomeRepository.deleteById(gastronomeId);
    }


    public Gastronome createGastronomeForLocation(long locationId, Gastronome gastronome) {
        // Retrieve the location by ID
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException("Location not found with id: " + locationId));

        // Set the location for the gastronome
        gastronome.setLocation(location);

        // Save the gastronome
        return gastronomeRepository.save(gastronome);
    }
}
