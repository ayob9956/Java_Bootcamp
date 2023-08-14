package com.example.homework17.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @Column(columnDefinition = "varchar(25) not null")
    private String name;


    @Column(columnDefinition = "varchar(20) not null unique ")
    @NotEmpty(message = "user name should not empty")
    private String username;

    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "password name should not empty")
    private String password;

    @Column(columnDefinition = "varchar(20) not null unique")
    @NotEmpty(message = "email name should not empty")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "in email shape!!")
    private String email;


    @Column(columnDefinition = "varchar(8) not null check(role in('admin','user'))")
    @NotEmpty(message = "role name should not empty")
    private String role;


    @Column(columnDefinition = "int not null")
    @NotNull(message = "age should not null")
    private Integer age;


}
