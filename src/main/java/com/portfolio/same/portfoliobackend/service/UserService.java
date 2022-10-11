/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.service;

import com.portfolio.same.portfoliobackend.model.User;
import com.portfolio.same.portfoliobackend.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    
    @Autowired
    public UserRepository repository;
    
    public User getUser(long id)
    {
        return repository.findById(id).orElse(null);
    }
    
    public List<User> getUsers()
    {
        return repository.findAll();
    }
    
    public void save(User user){
        repository.save(user);
    }
    
    public void delete(long id)
    {
        repository.deleteById(id);
    }
 
    public User findByName(String name)
    {
        return repository.findByName(name);
    }
    
    public boolean existByName(String name)
    {
        return repository.existsByName(name);
    }
}