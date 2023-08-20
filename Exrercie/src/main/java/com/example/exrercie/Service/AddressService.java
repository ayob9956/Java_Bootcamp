package com.example.exrercie.Service;

import com.example.exrercie.DTO.AddressDTO;
import com.example.exrercie.Models.Address;
import com.example.exrercie.Models.Teacher;
import com.example.exrercie.Repostry.AddressRepostry;
import com.example.exrercie.Repostry.TeacherRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final TeacherRepostry teacherRepostry;
    private final AddressRepostry addressRepostry;


    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepostry.findTeacherById(addressDTO.getTeacher_Id());

        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);

        addressRepostry.save(address);
    }

    public void deleteAddress(Integer teacher_Id){
        Teacher teacher=teacherRepostry.findTeacherById(teacher_Id);
        Address address = teacher.getAddress();

        addressRepostry.delete(address);

    }


    public void updateAddress(Integer teacher_id,AddressDTO addressDTO){
        Teacher teacher=teacherRepostry.findTeacherById(teacher_id);
        Address address = teacher.getAddress();


        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepostry.save(address);


    }


}
