package com.bs.spring.controller;

import com.bs.spring.common.propertyData.PropertyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyData propertyData;
    @GetMapping
    public String propertyDataCheck(){
        System.out.println(propertyData.getAppName());
        System.out.println(propertyData.getDbUrl());
        System.out.println(propertyData.getStudents());
        return "redirect:/";
    }
}
