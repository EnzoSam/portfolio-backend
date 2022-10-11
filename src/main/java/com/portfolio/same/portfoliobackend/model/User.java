/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter @Setter
@Entity
public class User extends PersistibleObject implements UserDetails{
    
    String name;
    String password;
    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    public User()
    {
    
    }
    
     public User(long id, String name, String password, 
             Collection<? extends GrantedAuthority> authorities)
     {
         this.setId(id);
         this.setName(name);
         this.setPassword(password);
         this.authorities = authorities;
     }
     
    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public static User build(User user){
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority a = new SimpleGrantedAuthority("ROLE_ADMIN");
        authorities.add(a);
        
        /**
        List<GrantedAuthority> authorities =
               user.getRoles().stream().map
        (rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        **/
        
        return new User(user.getId(), user.getName(), user.getPassword(), authorities);
        
        //return null;
    }    
}
