package com.arianit.CityGuideKosovo.service;

import com.arianit.CityGuideKosovo.entity.City;
import com.arianit.CityGuideKosovo.repository.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new EntityNotFoundException("City not found with id " + cityId));
    }

    public City saveCity(City city) {
        if (cityRepository.existsById(city.getCityId())) {
            throw new IllegalArgumentException("The city with this Id exists: " + city.getCityId());
        }
        return cityRepository.save(city);
    }

    public void deleteCity(long cityId) {
        if (!cityRepository.existsById(cityId)) {
            throw new EntityNotFoundException("The city with this id not found " + cityId);
        }
        cityRepository.deleteById(cityId);
    }

    public City updateCityName(long cityId, String newName) {
        Optional<City> optionalCity = cityRepository.findById(cityId);

        if (optionalCity.isPresent()) {
            City city = optionalCity.get();
            city.setNameOfCity(newName);
            return cityRepository.save(city);
        } else {
            throw new EntityNotFoundException("City not found with id " + cityId);
        }
    }
}
