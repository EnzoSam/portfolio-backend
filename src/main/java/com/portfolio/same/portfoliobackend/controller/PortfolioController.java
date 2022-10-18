package com.portfolio.same.portfoliobackend.controller;

import com.portfolio.same.portfoliobackend.model.Person;
import com.portfolio.same.portfoliobackend.model.Portfolio;
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


@CrossOrigin(origins = {"*"})
@RestController
public class PortfolioController {
    
    @Autowired
    private IPortfolioService service;
    
    @GetMapping("/api/auth/portfolio")
    @ResponseBody
    public Portfolio getPortfolio()
    {
        Portfolio portfolio = null;
        try {
            portfolio = service.getPortfolio();
        } catch (Exception ex) {
            Logger.getLogger(PortfolioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return portfolio;
    }    
    
}
