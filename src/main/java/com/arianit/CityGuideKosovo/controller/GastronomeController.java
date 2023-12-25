package com.arianit.CityGuideKosovo.controller;

import com.arianit.CityGuideKosovo.entity.Gastronome;
import com.arianit.CityGuideKosovo.service.GastronomeService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gastronomes")
public class GastronomeController {

    private final GastronomeService gastronomeService;

    @Autowired
    public GastronomeController(GastronomeService gastronomeService) {
        this.gastronomeService = gastronomeService;
    }

    @GetMapping
    public ResponseEntity<List<Gastronome>> getAllGastronomes() {
        List<Gastronome> gastronomes = gastronomeService.getAllGastronom();
        return new ResponseEntity<>(gastronomes, HttpStatus.OK);
    }

    @GetMapping("/{gastronomeId}")
    public ResponseEntity<Gastronome> getGastronomeById(@PathVariable long gastronomeId) {
        Gastronome gastronome = gastronomeService.getGastronomeById(gastronomeId);
        return new ResponseEntity<>(gastronome, HttpStatus.OK);
    }

    @PostMapping(value = "/createForLocation/{locationId}")
    public ResponseEntity<Gastronome> createGastronomeForLocation(
            @PathVariable Long locationId,
            @RequestBody Gastronome gastronome) {
        Gastronome createdGastronome = gastronomeService.createGastronomeForLocation(locationId, gastronome);
        return new ResponseEntity<>(createdGastronome, HttpStatus.CREATED);
    }


    @DeleteMapping("/{gastronomeId}")
    public ResponseEntity<String> deleteGastronomeById(@PathVariable long gastronomeId) {
        gastronomeService.deleteGastronomeById(gastronomeId);
        return new ResponseEntity<>("Gastronome deleted successfully", HttpStatus.NO_CONTENT);
    }
}
