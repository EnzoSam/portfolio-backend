/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Portfolio {
    
    Person person;
    List<Milestone> educations;
    List<Milestone> experiences;
}
