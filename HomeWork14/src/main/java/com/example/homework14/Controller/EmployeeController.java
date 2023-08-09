package com.example.homework14.Controller;

import com.example.homework14.ApiResponse.ApiResponse;
import com.example.homework14.Model.Employee;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    ArrayList<Employee> employees = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody @Valid Employee employee, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.add(employee);
        return ResponseEntity.status(200).body(new ApiResponse("Emploee is added"));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateEmployee(@PathVariable int index, @RequestBody @Valid Employee employee, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        employees.set(index, employee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee is updated"));

    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEmployee(@PathVariable int index) {

        employees.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("Emplyee is deleted"));

    }

    @PutMapping("/annul/{index}/{days}")
    public ResponseEntity updateAnnule(@PathVariable int index, @PathVariable int days) {
        if (employees.get(index).getAnnualLeave()<days){
            return ResponseEntity.status(400).body(new ApiResponse("your requste dayes is more than you have! "));
        }
            employees.get(index).setAnnualLeave(employees.get(index).getAnnualLeave() - days);
        return ResponseEntity.status(200).body(new ApiResponse("enjoy in your vacation!"));

    }

}
