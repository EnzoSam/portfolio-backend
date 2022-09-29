/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.model;

import java.util.Date;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Contact extends PersistibleObject{
    
    String name;
    String image;
    String contact;
    String type;
}
