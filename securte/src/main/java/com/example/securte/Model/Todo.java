package com.example.securte.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String title;


    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User user;
}
