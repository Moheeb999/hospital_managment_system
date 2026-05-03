package com.jpahibernate.example.hospital_management.service;


import com.jpahibernate.example.hospital_management.model.Patient;
import com.jpahibernate.example.hospital_management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public String saveDetails(Patient patient){
        patientRepository.save(patient);
        return "The patient data saved successfully";
    }



    public List<Patient> findAllPatients(){
        List<Patient> patientList=patientRepository.findAll();
        return patientList;
    }

    public Patient findPatientById(int id){
       Optional<Patient> optionalpatient = patientRepository.findById(id);
       return optionalpatient.orElse(null);
    }

    public String countNoPatients(){
        long total=patientRepository.count();
        return "The total number of Patients are "+total;
    }

    public String deleteById(int id){
        patientRepository.deleteById(id);
        return"The deleted of "+id+" is successfully completed";
    }
}
