/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.same.portfoliobackend.controller;

import com.portfolio.same.portfoliobackend.util.FileUtils;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "https://portfolio-fb9ed.firebaseapp.com")
public class FileController {
    
    @PostMapping("/api/upload")
     @ResponseBody
     @PreAuthorize("hasRole('ADMIN')")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
                              
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        FileUtils.saveFile("images", fileName, multipartFile);
        
        return  "{\"fileName\":\"" + fileName+ "\"}";
    }    
  
}
