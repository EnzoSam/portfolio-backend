/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.service;

import com.portfolio.same.portfoliobackend.model.Place;
import com.portfolio.same.portfoliobackend.repository.PlaceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService implements IPlaceService{
 
    @Autowired
    public PlaceRepository repository;
    
    public Place getPlace(long id)
    {
        return repository.findById(id).orElse(null);
    }
    
    public List<Place> getPlaces()
    {
        return repository.findAll();
    }
    
    public void save(Place place){
        repository.save(place);
    }
    
    public void delete(long id)
    {
        repository.deleteById(id);
    }
}
