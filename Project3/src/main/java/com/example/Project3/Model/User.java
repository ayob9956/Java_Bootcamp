package com.example.Project3.Model;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;

@Data
@RequiredArgsConstructor
public class User {
    @NotEmpty(message = "in User class your Id where is't ?!")
    private String id;
    @NotEmpty(message =  "in User class your UserName where is't ?!")
    @Size(min= 6,message =  "in User class your UserName is sholed more than 5!")
    private String username;
    @NotEmpty(message =  "in User class your Password where is't ?!")
    @Pattern(regexp = "([A-Za-z]*[0-9])\\w+",message = "in User class your Password Should be A_Z a_z 0_9")
    private String password;
    @NotEmpty(message = "in User class your Email where is't ?!" )
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "Your email Not! vaild!")
    private String email;
    @NotEmpty(message = "in User class your Role where is't ?!")
    @Pattern(regexp = "(Admin|Customer)",message = "in User class your ROle ether Admin or customer !!")
    private String role;
    @NotNull(message = "in User class your Balance where is't ?!" )
    @Min(value = 1,message = "in User class your balnce should be positve !" )
    private Integer balnce;

}
