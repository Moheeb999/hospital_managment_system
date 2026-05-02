package com.jpahibernate.example.hospital_management.controller;


import com.jpahibernate.example.hospital_management.model.Doctor;
import com.jpahibernate.example.hospital_management.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor doctor){
        String response = doctorService.saveDoctor(doctor);
        return response;
    }

    @GetMapping("/findById/{id}")
    public Doctor findDocbyId(@PathVariable int id){
        Doctor doctor=doctorService.findDocId(id);
        return doctor;
    }
    @GetMapping("/findall")
    public List<Doctor> findAll(){
        List<Doctor> doctorList=doctorService.findAllDoctors();
        return doctorList;
    }


    @GetMapping("/count")
    public String countdocs(){
        String response=doctorService.countdocs();
        return response;
    }

    @DeleteMapping("/deletebyId/{id}")
    public  String deletedocbyId(@PathVariable int id){
        String response=doctorService.deleteByid(id);
        return response;
    }
}
