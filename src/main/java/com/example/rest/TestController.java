package com.example.rest;

import com.example.config.AirlineConfig;
import com.example.config.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private Constant constant;
    
    @Autowired
    private AirlineConfig airlineConfig;
    
    @Value("${spring.application.name}")
    private String application;
    
    @RequestMapping("test")
    public String test() {
        System.out.println(constant.toString());
        System.out.println(airlineConfig.getAirlines());
        System.out.println(application);
        return "test";
    }
    
}
