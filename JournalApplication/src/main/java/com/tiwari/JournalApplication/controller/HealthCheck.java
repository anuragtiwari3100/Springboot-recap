package com.tiwari.JournalApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("/health-check")
   public String healthCheck(){
       return "ok";
   }

 @GetMapping("/sakshi")
    public  String abhi(){
        return "Radhe-Radhe govinda-givinda radhe";
 }
}
