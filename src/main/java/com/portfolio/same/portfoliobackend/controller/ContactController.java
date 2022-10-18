/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.controller;

import com.portfolio.same.portfoliobackend.model.Contact;
import com.portfolio.same.portfoliobackend.model.Skill;
import com.portfolio.same.portfoliobackend.service.IContactService;
import com.portfolio.same.portfoliobackend.service.ISkillService;
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
@CrossOrigin(origins = "https://portfolio-fb9ed.firebaseapp.com")
public class ContactController {
   @Autowired
     private IContactService service;
     
    @GetMapping("/api/contacts")
    @ResponseBody
    public List<Contact> getContacts()
    {
        List<Contact> listReturn = null;
        try {
            
            listReturn = service.getContacts();
        } catch (Exception ex) {
            Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listReturn;
    }  
    
    @GetMapping("/api/contact/{id}")
    @ResponseBody
    public Contact getContact(@PathVariable long id)
    {
        Contact contact = null;
        try {
            
            contact = service.getContact(id);
        } catch (Exception ex) {
            Logger.getLogger(ContactController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contact;
    } 
    
    @PostMapping("/api/contact/save")
    @PreAuthorize("hasRole('ADMIN')")
    public void save(@RequestBody Contact contact)
    {
        if(contact != null)
        {
            service.save(contact);
        }
        else
        {
            System.out.println("Contacto null");
        }
    }    
    
    @DeleteMapping("/api/contact/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id)
    {
        service.delete(id);
    }
}
