package com.arianit.CityGuideKosovo.repository;

import com.arianit.CityGuideKosovo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Long> {
    @Modifying
    @Query("UPDATE City c SET c.nameOfCity = :newName WHERE c.cityId = :cityId")
    void updateNameOfCityById(long cityId, String newName);
}
