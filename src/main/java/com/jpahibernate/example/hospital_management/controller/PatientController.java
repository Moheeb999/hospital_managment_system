package com.jpahibernate.example.hospital_management.controller;


import com.jpahibernate.example.hospital_management.model.Patient;
import com.jpahibernate.example.hospital_management.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/findAllPatients")
    public List<Patient> findAllPatients(){
        List<Patient> patientList=patientService.findAllPatients();
        return patientList;
    }


    @GetMapping("/findPatientbyId/{id}")
    public Patient findbyPatientById(@PathVariable int id){
        Patient optionalPatient  = patientService.findPatientById(id);
        return optionalPatient;
    }

    @GetMapping("/countAllPatients")
    public String countAllPatients(){
        return patientService.countNoPatients();
    }


    @DeleteMapping("/deletingbyid/{id}")
    public String deleteWithId(@PathVariable  int id){
        return patientService.deleteById(id);
    }


}
