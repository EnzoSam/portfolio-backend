package com.portfolio.same.portfoliobackend.controller;

import com.portfolio.same.portfoliobackend.model.Person;
import com.portfolio.same.portfoliobackend.model.User;
import com.portfolio.same.portfoliobackend.service.IPortfolioService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PortfolioController {
    
    @Autowired
    private IPortfolioService service;
    
    @GetMapping("/api/portfolio")
    @ResponseBody
    public Person getPerson()
    {
        Person person = null;
        try {
            person = service.getPortfolioPerson();
        } catch (Exception ex) {
            Logger.getLogger(PortfolioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return person;
    }    
    
    @PostMapping("/api/person/save")
    public void savePerson(@RequestBody Person person)
    {
        service.savePerson(person);
    }
    
    @PostMapping("/api/login")
    public boolean login(@RequestBody User user)
    {
        return "enzo".equals(user.getName()) && "password".equals(user.getPassword());
    }
}
