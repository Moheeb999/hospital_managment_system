package com.jpahibernate.example.hospital_management.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ward {
    @Id
    @Column(name="Ward_id",nullable = false,unique = true)
    private int ward_id;

    @Column(name="Ward_Name",nullable = false)
    private String ward_name;

    @Column(name="total_beds_in_ward",nullable = false)
    private int total_beds;

    @Column(name="Available_beds_in_ward",nullable = false)
    private int avail_beds;


    @Column(name="Ward_Type",nullable = false)
    private String ward_type;
}
