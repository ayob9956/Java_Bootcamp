package com.example.exrercie.Controller;


import com.example.exrercie.DTO.AddressDTO;
import com.example.exrercie.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body("is add");
    }


    @DeleteMapping("/delete/{teacher_Id}")
    public ResponseEntity deleteAddress(@PathVariable Integer teacher_Id) {
        addressService.deleteAddress(teacher_Id);
        return ResponseEntity.status(200).body("is deleted");
    }

    @PutMapping("/update/{teacher_Id}")
    public ResponseEntity updateAddress(@PathVariable Integer teacher_Id,
                                        @RequestBody AddressDTO addressDTO){
        addressService.updateAddress(teacher_Id,addressDTO);
        return ResponseEntity.status(200).body("is update");

    }
}
