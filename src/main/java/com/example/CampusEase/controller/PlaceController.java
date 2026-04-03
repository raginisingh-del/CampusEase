package com.example.CampusEase.controller;

import com.example.CampusEase.model.Place;
import com.example.CampusEase.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @GetMapping("/{id}")
    public Place getPlace(@PathVariable Long id) {
        return placeService.getPlaceById(id);
    }

    @PostMapping
    public Place addPlace(@RequestBody Place place) {
        return placeService.addPlace(place);
    }

    @PutMapping("/{id}")
    public Place updatePlace(@PathVariable Long id, @RequestBody Place place) {
        return placeService.updatePlace(id, place);
    }

    @DeleteMapping("/{id}")
    public String deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
        return "Place deleted successfully!";
    }
}