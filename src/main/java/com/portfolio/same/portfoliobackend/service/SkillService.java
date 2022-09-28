/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.service;

import com.portfolio.same.portfoliobackend.model.Place;
import com.portfolio.same.portfoliobackend.model.Skill;
import com.portfolio.same.portfoliobackend.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{
    
    @Autowired
    public SkillRepository repository;
    
    public Skill getSkill(long id)
    {
        return repository.findById(id).orElse(null);
    }
    
    public List<Skill> getSkills()
    {
        return repository.findAll();
    }
    
    public void save(Skill skill){
        repository.save(skill);
    }
    
    public void delete(long id)
    {
        repository.deleteById(id);
    }
    
}