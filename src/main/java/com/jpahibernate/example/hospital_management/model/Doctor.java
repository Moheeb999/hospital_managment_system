package com.jpahibernate.example.hospital_management.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //This represents this class as entity or model class
@Table(name="doctor")
@Data // it will add getter and setter
@NoArgsConstructor//default Constructoprs
@AllArgsConstructor//Parameterized Constructor

public class Doctor {

    @Id
    @Column(name="doctor_id",nullable = false,unique = true)
    private int id;

    @Column(name ="doctor_name",nullable = false)
    private String name;

    @Column(name="doctor_email",nullable = false,unique = true)
    private String email;


    @Column(name="doctor_dob",nullable = false)
    private String dob;


    @Column(name="doctor_spec",nullable = false)
    private String specialization;


    @Column(name="doctor_mobile",nullable = false,unique = true)
    private String mobile;

}
