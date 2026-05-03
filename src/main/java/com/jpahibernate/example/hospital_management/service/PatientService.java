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

    //Update via put -- Entire body it does
    public String update_patient_put(int id,Patient newPatient){
        //find if patient exists
        Patient existing  = findPatientById(id);
        if(existing!=null){
            patientRepository.save(newPatient);
            return "The ID "+id+" has been successfully updated";
        }
        else{
            return "The ID "+id+" doesn't exist";
        }
    }

    //Update via patch -- Single field
    public String update_patient_patch(int id,String newphno,String newgender){
        //find if patient exists
        Patient existing  = findPatientById(id);
        if(existing!=null){
            existing.setPhno(newphno);
            existing.setGender(newgender);
            patientRepository.save(existing);
            return "The ID "+id+" has been successfully updated";
        }
        else{
            return "The ID "+id+" doesn't exist";
        }
    }
}
