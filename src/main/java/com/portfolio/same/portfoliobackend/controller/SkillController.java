/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.controller;

import com.portfolio.same.portfoliobackend.dto.Message;
import com.portfolio.same.portfoliobackend.model.Skill;
import com.portfolio.same.portfoliobackend.service.ISkillService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
@Validated
public class SkillController {
   @Autowired
     private ISkillService service;
     
    @GetMapping("/api/skills")
    @ResponseBody
    public List<Skill> getSkills()
    {
        List<Skill> listReturn = null;
        try {
            
            listReturn = service.getSkills();
        } catch (Exception ex) {
            Logger.getLogger(SkillController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listReturn;
    }  
    
    @GetMapping("/api/skill/{id}")
    @ResponseBody
    public Skill getSkill(@PathVariable long id)
    {
        Skill skill = null;
        try {
            
            skill = service.getSkill(id);
        } catch (Exception ex) {
            Logger.getLogger(SkillController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return skill;
    } 
    
    @PostMapping("/api/skill/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity save(@RequestBody @Valid Skill skill)
    {       
        service.save(skill);
        return ResponseEntity.ok(skill);
    }    
    
    @DeleteMapping("/api/skill/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id)
    {
        service.delete(id);
    }
}
