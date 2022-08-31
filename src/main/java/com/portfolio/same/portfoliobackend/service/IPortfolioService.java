/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.same.portfoliobackend.service;

import com.portfolio.same.portfoliobackend.model.Person;

/**
 *
 * @author enzos
 */
public interface IPortfolioService {
    
    public Person getPortfolioPerson() throws Exception;
    public Person savePerson(Person person);
}
