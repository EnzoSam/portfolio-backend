/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.repository;

import com.portfolio.same.portfoliobackend.model.Milestone;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilestoneRepository  extends JpaRepository<Milestone,Long> {
 
    public List<Milestone> findByType(String type);
}
