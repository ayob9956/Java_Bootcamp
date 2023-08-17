package com.example.library.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Librarian {
    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Column(columnDefinition = "varchar(20) not null unique")

    private String username;

    @Column(columnDefinition = "varchar(20) not null")
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "password not valid!")
    private String password;//(use pattren)
    @Column(columnDefinition = "varchar(40) not null unique")
    @Email
    private String email;// (valid email) (check unique)
}
