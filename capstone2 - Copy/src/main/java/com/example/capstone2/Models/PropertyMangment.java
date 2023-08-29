package com.example.capstone2.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class PropertyMangment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "put the code")
    private String code;
    @NotEmpty(message = "put rhe Name")
    @Column(nullable = false,columnDefinition = "varchar(25)")
    private String nameofowner;

    @Column(nullable = false,columnDefinition = "int")
    private Integer expectedincome;


    @Column(nullable = false,columnDefinition = "int")
    private Integer price;


    @OneToMany(mappedBy = "renters",cascade = CascadeType.ALL)
    private List<Tenants> tenants;


    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private User user;





}
