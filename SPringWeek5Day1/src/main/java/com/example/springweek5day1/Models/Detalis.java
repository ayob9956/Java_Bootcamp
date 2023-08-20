package com.example.springweek5day1.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Detalis {

    @Id
    private Integer id;

    private String gender;

    private Integer age;

    private String email;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Customer customer;

}
