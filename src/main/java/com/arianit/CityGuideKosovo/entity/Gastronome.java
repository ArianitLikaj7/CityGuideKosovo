package com.arianit.CityGuideKosovo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "gastronomies")
public class Gastronome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gastronome_id")
    private Long gastronomeId;


    @Column(nullable = false)
    private String nameOfGastronome;

    @Column(length = 255)
    private String schedule;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

}
