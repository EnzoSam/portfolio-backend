/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.same.portfoliobackend.service;

import com.portfolio.same.portfoliobackend.model.Place;
import java.util.List;

/**
 *
 * @author enzos
 */
public interface IPlaceService {
    
    public Place getPlace(long id);
    public List<Place> getPlaces();
    public void save(Place place);
    public void delete(long id);
}
