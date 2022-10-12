package com.portfolio.same.portfoliobackend.controller;

import com.portfolio.same.portfoliobackend.model.Person;
import com.portfolio.same.portfoliobackend.model.User;
import com.portfolio.same.portfoliobackend.service.IPersonaService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Validated
public class PersonaController {
    
    @Autowired
    private IPersonaService service;
    
    @GetMapping("/api/person")
    @ResponseBody
    public Person getPerson()
    {
        Person person = null;
        try {
            person = service.getPerson();
        } catch (Exception ex) {
            Logger.getLogger(PersonaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return person;
    }    
    
    @PostMapping("/api/person/save")
    @PreAuthorize("hasRole('ADMIN')")
    public void savePerson(@RequestBody Person person)
    {
        service.save(person);
    }
    
}
