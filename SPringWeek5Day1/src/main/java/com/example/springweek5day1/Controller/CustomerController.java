package com.example.springweek5day1.Controller;


import com.example.springweek5day1.Models.Customer;
import com.example.springweek5day1.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(customerService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody @Valid Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Customer is add");
    }

@PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@RequestBody @Valid Customer customer, @PathVariable Integer id){
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(200).body("Customer is Updated");
    }

    @DeleteMapping("/delete/{customer_id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer customer_id){
        customerService.deleteCUstomer(customer_id);
        return ResponseEntity.status(200).body(getAll());
    }



}
