package com.example.exam1.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Student {

    @NotEmpty(message = "ID should be not empty")
    String id;
    @NotEmpty(message = "ID should be not empty")
    String name;
    @NotNull(message = "ID should be not empty")
    Integer age;
    @NotEmpty(message = "ID should be not empty")
    String major;
}
