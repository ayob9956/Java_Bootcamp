package com.example.Project3.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class Merchant {
    @NotEmpty(message = " in Merchant class your Id where is't ?!")
    private String id;
    @NotEmpty(message = "in Merchant class your Name where is't ?!")
    private String name;

}