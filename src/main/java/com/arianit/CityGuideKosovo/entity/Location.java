package com.arianit.CityGuideKosovo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private long locationId;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private String description;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Gastronome> gastronome;

    private Double longitude;

    private Double latitude;
}
