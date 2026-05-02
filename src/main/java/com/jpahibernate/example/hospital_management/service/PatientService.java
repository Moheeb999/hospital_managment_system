package com.jpahibernate.example.hospital_management.service;


import com.jpahibernate.example.hospital_management.model.Patient;
import com.jpahibernate.example.hospital_management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public String saveDetails(Patient patient){
        patientRepository.save(patient);
        return "The patient data saved successfully";
    }
}
