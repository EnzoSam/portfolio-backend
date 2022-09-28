/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.same.portfoliobackend.service;

import com.portfolio.same.portfoliobackend.model.Place;
import com.portfolio.same.portfoliobackend.model.Skill;
import java.util.List;

/**
 *
 * @author enzos
 */
public interface ISkillService {
    
    public Skill getSkill(long id);
    public List<Skill> getSkills();
    public void save(Skill skill);
    public void delete(long id);    
}
