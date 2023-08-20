package com.example.springweek5day1.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String  name;


    @OneToOne(cascade = CascadeType.DETACH ,mappedBy = "customer")
    @PrimaryKeyJoinColumn
    private Detalis detalis;
}
