package com.jpahibernate.example.hospital_management.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @Column(name="Patient_ID",nullable = false,unique = true)
    private int id;

    @Column(name="Patient_name",nullable = false)
    private String name;

    @Column(name="Patient_DOB",nullable = false)
    private String dob;

    @Column(name="Patient_gender",nullable = false)
    private String gender;

    @Column(name="Patient_phno",nullable = false,unique = true)
    private String phno;
}
