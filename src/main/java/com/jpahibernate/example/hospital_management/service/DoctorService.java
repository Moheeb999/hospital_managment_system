package com.jpahibernate.example.hospital_management.service;

import com.jpahibernate.example.hospital_management.model.Doctor;
import com.jpahibernate.example.hospital_management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public String saveDoctor(Doctor doctor){

        doctorRepository.save(doctor);
        return "Doctor is saved successfully";
    }


    public List<Doctor> findAllDoctors(){
        List<Doctor> doctorList=doctorRepository.findAll();
        return doctorList;
    }

    public Doctor findDocId(int doctorId){
        Optional<Doctor> doctorOptional=doctorRepository.findById(doctorId);
        if(doctorOptional.isPresent()){
            return doctorOptional.get();
        }
        else{
            return null;
        }
    }

    public String countdocs(){
        long total=doctorRepository.count();
        return "The total no of doctors are:"+total;
    }


    public  String deleteByid(int id){
        doctorRepository.deleteById(id);
        return "The doctor with Id:"+id+"successfully deleted";
    }
}
