/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.service;

import com.portfolio.same.portfoliobackend.model.Contact;
import com.portfolio.same.portfoliobackend.repository.ContactRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService implements IContactService{
 
    @Autowired
    public ContactRepository repository;
    
    public Contact getContact(long id)
    {
        return repository.findById(id).orElse(null);
    }
    
    public List<Contact> getContacts()
    {
        return repository.findAll();
    }
    
    public void save(Contact contact){
        repository.save(contact);
    }
    
    public void delete(long id)
    {
        repository.deleteById(id);
    }
}
