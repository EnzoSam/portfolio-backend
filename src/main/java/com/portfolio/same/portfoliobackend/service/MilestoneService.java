/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.service;

import com.portfolio.same.portfoliobackend.model.Milestone;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.same.portfoliobackend.repository.MilestoneRepository;

@Service
public class MilestoneService implements IMilestoneService {
 
    @Autowired
    public MilestoneRepository repository;
    
    public List<Milestone> findByType(String type)
    {
        return repository.findByType(type);
    }
    
    public Milestone findById(long id)
    {
        return repository.findById(id).orElse(null);
    }
    
    public void save(Milestone education)
    {
        repository.save(education);
    }
    
    public void delete(long id)
    {
        repository.deleteById(id);
    }
}
