package com.example.springweek5day1.Controller;


import com.example.springweek5day1.DTO.CustomerDTO;
import com.example.springweek5day1.Models.Detalis;
import com.example.springweek5day1.Service.DetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/details")
public class DetailsController {


    private final DetailsService detailsService;


    @PostMapping("/add")
    public ResponseEntity addDetails(@RequestBody @Valid CustomerDTO customerDTO) {

        detailsService.addDetails(customerDTO);
        return ResponseEntity.status(200).body("is added");
    }

    @DeleteMapping("/delete/{customer_id}")
    public ResponseEntity deleteDetails(@PathVariable Integer customer_id) {
        detailsService.deleteDetails(customer_id);
        return ResponseEntity.status(200).body("is deleted");
    }

    @PutMapping("/update/{customer_id}")
    public ResponseEntity updateDetails(@PathVariable Integer customer_id,
                                        @RequestBody CustomerDTO customerDTO){
        detailsService.updateDetails(customer_id, customerDTO);
        return ResponseEntity.status(200).body("is update");

    }


}
