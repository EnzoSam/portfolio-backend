/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.controller;

import com.portfolio.same.portfoliobackend.model.Place;
import com.portfolio.same.portfoliobackend.service.IPlaceService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://portfolio-fb9ed.firebaseapp.com","https://portfolio-fb9ed.web.app"})
public class PlaceController {
   @Autowired
     private IPlaceService service;
     
    @GetMapping("/api/places")
    @ResponseBody
    public List<Place> getPlaces()
    {
        List<Place> listReturn = null;
        try {
            
            listReturn = service.getPlaces();
        } catch (Exception ex) {
            Logger.getLogger(PlaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listReturn;
    }  
    
    @GetMapping("/api/place/{id}")
    @ResponseBody
    public Place getPlace(@PathVariable long id)
    {
        Place place = null;
        try {
            
            place = service.getPlace(id);
        } catch (Exception ex) {
            Logger.getLogger(PlaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return place;
    } 
    
    @PostMapping("/api/place/save")
    @PreAuthorize("hasRole('ADMIN')")
    public void save(@RequestBody Place place)
    {
        if(place != null)
        {
            service.save(place);
        }
        else
        {
            System.out.println("Lugar nula");
        }
    }    
    
    @DeleteMapping("/api/place/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")    
    public void delete(@PathVariable Long id)
    {
        service.delete(id);
    }
}
