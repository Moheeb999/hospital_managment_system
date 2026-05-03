package com.jpahibernate.example.hospital_management.service;

import com.jpahibernate.example.hospital_management.model.Doctor;
import com.jpahibernate.example.hospital_management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
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



    //Update using put operation--to update the complete object
    public String updatedoctorwithput(int id, Doctor newDoctorRequest){
        //find doctor with id
        //if doctor is present update it
        //else we cannot update
        Doctor existingDoc = findDocId(id);
        if(existingDoc!=null){
            //We can update
            doctorRepository.save(newDoctorRequest);
            return "The new Doctor Details are updated successfully with ID"+id;
        }
        else{
            //we cannot update
            return "The doctor with ID "+id+" cannot be updated as it doesn't exist";
        }
    }


    //Update using patch operation -- to update single field
    public String updatedoctorwithpatch(int id, String newMobile,String newEmail){
        //find doctor with id
        //if doctor is present update it
        //else we cannot update
        Doctor existingDoc = findDocId(id);
        if(existingDoc!=null){
            //We can update
            existingDoc.setEmail(newEmail);
            existingDoc.setMobile(newMobile);
            doctorRepository.save(existingDoc);
            return "The new Doctor Details are updated successfully with ID"+id;
        }
        else{
            //we cannot update
            return "The doctor with ID "+id+" cannot be updated as it doesn't exist";
        }
    }
}
