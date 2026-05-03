package com.jpahibernate.example.hospital_management.controller;

import com.jpahibernate.example.hospital_management.model.Ward;
import com.jpahibernate.example.hospital_management.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ward/api")
public class WardController {
    @Autowired
    WardService wardService;

    @PostMapping("/savedata")
    public String saveData(@RequestBody Ward ward){

        return wardService.saveWardData(ward);
    }

    @GetMapping("/display-ward-data")
    public List<Ward> allWardData(){
        return wardService.findAll();
    }


    @GetMapping("/findWithId/{id}")
    public Ward findWithId(@PathVariable  int id){
        return wardService.findbyid(id);
    }

    @GetMapping("/count-no-wards")
    public String countWardNo(){
        long total=wardService.countnowards();
        return "The number of wards are:"+total;
    }

    @DeleteMapping("/deletebyid/{id}")
    public String deletebyid(@PathVariable int id){
        return wardService.deletebyid(id);
    }
}
