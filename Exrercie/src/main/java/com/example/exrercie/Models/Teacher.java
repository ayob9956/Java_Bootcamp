package com.example.exrercie.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "area not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotNull(message = "area not Null")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotEmpty(message = "area not empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String email;
    @NotNull(message = "area not empty")
    @Column(columnDefinition = "int not null")
    private Integer salary;



    @OneToOne(cascade = CascadeType.DETACH ,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;



    @OneToMany(cascade = CascadeType.ALL, mappedBy="teacher")
    private Set<Course> course;
}
