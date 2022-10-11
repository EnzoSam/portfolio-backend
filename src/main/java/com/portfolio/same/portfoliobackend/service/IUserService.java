/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.same.portfoliobackend.service;

import com.portfolio.same.portfoliobackend.model.User;
import java.util.List;

/**
 *
 * @author enzos
 */
public interface IUserService {
    
    public User getUser(long id);
    public List<User> getUsers();
    public void save(User user);
    public void delete(long id);  
    public User findByName(String name);
    public boolean existByName(String name);
}
