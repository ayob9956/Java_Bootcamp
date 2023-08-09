package com.example.homework14.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

@Data
@AllArgsConstructor
public class Employee {
    @NotEmpty(message = "id sholed not emptey")

    @Size(min = 3,max = 10,message = "id sholed gerthers than 3!!!!")
    private String ID;
    @NotEmpty(message = "name sholed not emptey")
//    @Min(value = 4,message = "should name gerther than 4")
    @Size(min = 4,max = 15,message = "should name gerther than 4")
    private String name;
    @NotEmpty(message = "postion shold not emptey!")
    @Pattern(regexp = "(supervisor|coordinator)", message = "user role not valid!")
    private String position;

    private boolean onLeave = false;
    @NotNull(message = " emp years shold be not null")
    @Max(value = 2023,message = "emp years sholed be lees than 2023")
    @Min(value = 1950,message = "emp years sholed be grether than 1950" )
    private int employmentYear;
    @NotNull(message = "sholed age not null")
    @Min(value = 26,message = "age sholed greter than 25")
    private int age;
    @NotNull(message = "annul sholed not null")
    private int annualLeave;

}
