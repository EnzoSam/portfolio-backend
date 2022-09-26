/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.service;

import com.portfolio.same.portfoliobackend.model.Person;
import com.portfolio.same.portfoliobackend.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService implements IPortfolioService{
 
    @Autowired
    public PersonaRepository repository;
    
    @Override
     public Person getPortfolioPerson() throws Exception 
     {
         List<Person> list = repository.findAll();
         if(list.size() > 1)
             throw new Exception("Solo puede haber una persona definida");
         if(list.size() == 1)
             return list.get(0);
         else
             return new Person();
     }
     
    @Override
     public Person savePerson(Person person)
     {         
         return repository.save(person);
     }
    
}
