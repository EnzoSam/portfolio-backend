/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.service;

import com.portfolio.same.portfoliobackend.model.Milestone;
import com.portfolio.same.portfoliobackend.model.Person;
import com.portfolio.same.portfoliobackend.model.Portfolio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService implements IPortfolioService {

    @Autowired
    private IPersonaService personService;
    @Autowired
    private IMilestoneService milestoneService;    
    @Autowired
    private ISkillService skillService;
    @Autowired
    private IContactService contactService;    

    public Portfolio getPortfolio() throws Exception {
        
        Portfolio portfolio = new Portfolio();
        portfolio.setPerson(personService.getPerson());
        portfolio.setEducations(milestoneService.findByType(Milestone.TYPE_EDUCATION));
        portfolio.setExperiences(milestoneService.findByType(Milestone.TYPE_LABORAL_EXPERIENCE));
        portfolio.setContacts(contactService.getContacts());
        portfolio.setSkills(skillService.getSkills());

        return portfolio;
    }
}
