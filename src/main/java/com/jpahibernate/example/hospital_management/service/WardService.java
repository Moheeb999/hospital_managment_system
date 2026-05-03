package com.jpahibernate.example.hospital_management.service;


import com.jpahibernate.example.hospital_management.model.Ward;
import com.jpahibernate.example.hospital_management.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WardService  {

    @Autowired
    WardRepository wardRepository;

    public String saveWardData(Ward ward){
       wardRepository.save(ward);
       return "The Ward data is saved successfully";
    }

    public List<Ward> findAll(){
        List<Ward> wardList=wardRepository.findAll();
        return wardList;
    }

    public Ward findbyid(int id){
        Optional<Ward> optionalWard=wardRepository.findById(id);
        return optionalWard.orElse(null);
    }


    public long countnowards(){
        return wardRepository.count();
    }

    public String deletebyid(int id){
        wardRepository.deleteById(id);
        return "The ID "+id+" has been successfully deleted";
    }

    //Update via put -- Entire body it does
    public String update_put_ward(int id,Ward newWard){
        Ward existing =findbyid(id);
        if(existing!=null){
            wardRepository.save(newWard);
            return "The ward record with ID"+id+"successfully updated";
        }
        else{
            return "The ward record cannot be found as per ID "+id;
        }
    }

    //Update via patch -- Single field
    public String update_patch_ward(int id,int newBeds,int newAvail_beds){
        Ward existing =findbyid(id);
        if(existing!=null){
            existing.setTotal_beds(newBeds);
            existing.setAvail_beds(newAvail_beds);
            wardRepository.save(existing);
            return "The ward record with ID"+id+"successfully updated";
        }
        else{
            return "The ward record cannot be found as per ID "+id;
        }
    }




}
