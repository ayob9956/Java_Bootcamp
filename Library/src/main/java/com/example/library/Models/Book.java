package com.example.library.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Data
public class Book {

    @Id
    private Integer id;
    @NotEmpty(message = "the title is should not empty!!")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;

    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "where is the Author!!")

    private String author;

    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "category is should be not null check( Category= 'Academic' or Category='Mystery' or Category='Novel' )")
    private String category;// (check Academic or Mystery or Novel )
    @NotNull(message = "ISBN NOt null!!!")
    @Column(columnDefinition = "varchar(20) not null")
    private Integer isbn;

    @Min(value = 50, message = "pages is at least is 50!!")
    private Integer numberofpages;
}
