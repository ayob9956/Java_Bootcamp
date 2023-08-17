package com.example.library.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "the title is should not empty!!")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;

    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "where is the Author!!")

    private String author;

    @Column(columnDefinition = "varchar(20) not null check( Category= 'Academic' or Category='Mystery' or Category='Novel' )")
    @NotEmpty(message = " not null ")
    private String category;// (check Academic or Mystery or Novel )
    @NotNull(message = "ISBN NOt null!!!")
    @Column(columnDefinition = "int not null")
    private Integer isbn;

    @Min(value = 50, message = "pages is at least is 50!!")
    private Integer numberofpages;
}
