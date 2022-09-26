/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Milestone  extends PersistibleObject{
    
    public static final String TYPE_EDUCATION = "EDUCATION";
    public static final String TYPE_LABORAL_EXPERIENCE = "EXPERIENCE";
    
    @ManyToOne
    Place place;
    Date fromDate;
    Date toDate;
    String name;
    String description;
    String type;
}
