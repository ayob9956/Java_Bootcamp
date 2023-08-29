package com.example.capstone2.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Tenants {
    @Id
    private String contract;
    @Column(nullable = false,columnDefinition = "varchar(20)")
    private String nameoftenant;
    @Column(nullable = false,columnDefinition = "DATE")
    private String startdate;


    @Column(nullable = false,columnDefinition = "DATE")
    private String enddate;

    private String buildingcode;


    private String numberofflate;
    @Column(columnDefinition = "int",nullable = false)
    private Integer price;


    @Column(columnDefinition = "int default 0",nullable = false)
    private Integer balanceOfTenant;

    @Column( columnDefinition = "int default 10000",nullable = false)
    private Integer balnaceOfRenter;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private PropertyMangment renters;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private User user;

}
