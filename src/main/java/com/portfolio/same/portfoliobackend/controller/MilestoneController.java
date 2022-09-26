/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.controller;

import com.portfolio.same.portfoliobackend.model.Milestone;
import com.portfolio.same.portfoliobackend.model.Milestone;
import com.portfolio.same.portfoliobackend.model.Person;
import com.portfolio.same.portfoliobackend.service.IMilestoneService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MilestoneController {
 
     @Autowired
     private IMilestoneService service;
     
    @GetMapping("/api/milestones/{type}")
    @ResponseBody
    public List<Milestone> getMilestone(@PathVariable String type)
    {
        List<Milestone> listReturn = null;
        try {
            
            listReturn = service.findByType(type);
        } catch (Exception ex) {
            Logger.getLogger(MilestoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listReturn;
    }  
    
    @GetMapping("/api/milestone/{id}")
    @ResponseBody
    public Milestone getMilestone(@PathVariable long id)
    {
        System.out.println(id);
        Milestone milestone = null;
        try {
            
            milestone = service.findById(id);
        } catch (Exception ex) {
            Logger.getLogger(MilestoneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return milestone;
    } 
    
    @PostMapping("/api/milestone/save")
    public void save(@RequestBody Milestone milestone)
    {
        if(milestone != null)
        {
            service.save(milestone);
        }
        else
        {
            System.out.println("Educacion nula");
        }
    }    
    
    @DeleteMapping("/api/milestone/delete/{id}")
    public void delete(@PathVariable Long id)
    {
        service.delete(id);
    }
}
