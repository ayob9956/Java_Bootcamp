package com.example.exrercie.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {


    private Integer teacher_Id;
    private String area;
    private String street;
    private String buildingNumber;

}
