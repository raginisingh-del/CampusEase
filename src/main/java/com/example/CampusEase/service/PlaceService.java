package com.example.CampusEase.service;

import com.example.CampusEase.model.Place;
import com.example.CampusEase.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public Place getPlaceById(Long id) {
        return placeRepository.findById(id).orElse(null);
    }

    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }

    public Place updatePlace(Long id, Place updatedPlace) {
        Place existing = placeRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedPlace.getName());
            existing.setType(updatedPlace.getType());
            existing.setLocation(updatedPlace.getLocation());
            return placeRepository.save(existing);
        }
        return null;
    }

    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }
}