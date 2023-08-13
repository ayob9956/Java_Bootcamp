package com.example.Project3.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class Category {
    @NotEmpty(message = " in category class your Id where is't ?!")
    @Size(min = 4,message = "Sholed more than 3 charcter")
    private String id;
    @NotEmpty(message = "in category class your Name where is't ?!")
    @Size(min = 4,message = "Sholed more than 4 charcter")
    private String name;

}
