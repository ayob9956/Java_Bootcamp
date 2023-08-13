package com.example.Project3.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {
    @NotEmpty(message = "your Product Id where is't ?! ")
    private String id;
    @NotEmpty(message = "your Name where is't ?! ")
    @Size(min = 3, message = "sholed more than 3 ")
    private String name;
    @NotNull(message = "your product is not free!! ")
    private Integer price;
    @NotEmpty(message = "your Category Id where is't ?! ")
    private String categoryID;

}
