package com.example.exrercie.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id;
    @NotEmpty(message = "area not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;

    @NotEmpty(message = "area not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;
    @NotEmpty(message = "area not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
