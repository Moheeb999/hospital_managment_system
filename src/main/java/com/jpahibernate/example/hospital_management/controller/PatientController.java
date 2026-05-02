package com.jpahibernate.example.hospital_management.controller;


import com.jpahibernate.example.hospital_management.model.Patient;
import com.jpahibernate.example.hospital_management.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/patient/api")
public class PatientController {

    @Autowired
    PatientService patientService;


    @PostMapping("/save")
    public String savePatientDetails(@RequestBody Patient patient){

        String response=patientService.saveDetails(patient);
        return response;

    }
}
