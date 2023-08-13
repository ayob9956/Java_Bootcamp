package com.example.exam1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Teacher {

    @NotEmpty(message = "id souled not emptey")
    String id;
    @NotEmpty(message = "name souled not emptey")
    String name;
    @NotNull(message = "salary sholed not null!!")
    Integer salary;
}
