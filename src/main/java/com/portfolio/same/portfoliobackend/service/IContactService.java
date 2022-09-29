/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.same.portfoliobackend.service;

import com.portfolio.same.portfoliobackend.model.Contact;
import java.util.List;

/**
 *
 * @author enzos
 */
public interface IContactService {
    
    public Contact getContact(long id);
    public List<Contact> getContacts();
    public void save(Contact contact);
    public void delete(long id);    
}
