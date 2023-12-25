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

    @Entity
    @Table(name = "cities")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class City {

        @Id
        @GeneratedValue
        private long cityId;

        @Column(nullable = false)
        private String nameOfCity;

        @Column(nullable = false)
        private String culturalHeritage;

        @OneToMany(mappedBy = "city")
        @JsonIgnore
        private List<Location> locations;

    }
