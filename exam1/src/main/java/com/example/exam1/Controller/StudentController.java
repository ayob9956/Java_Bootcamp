package com.example.exam1.Controller;

import com.example.exam1.ApiResponse.ApiResponse;
import com.example.exam1.Model.Student;
import com.example.exam1.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    public final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent(){
        if (studentService.getStudents()==null){
            return ResponseEntity.status(400).body(new ApiResponse("Student class is null!"));
        }
        return ResponseEntity.status(200).body(studentService.getStudents());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        studentService.addStudent(student);
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@RequestBody @Valid Student student,
                                        @PathVariable String id,
                                        Errors errors){
        if (errors.hasErrors()){
            String message  = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isupdeted =  studentService.updateStudent(student,id);
        if (isupdeted){
            return ResponseEntity.status(200).body(new ApiResponse("Student is updated!!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse(" id not found!"));

    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(
                                        @PathVariable String id
                                        ){


        boolean isdeleted =  studentService.deleteStudent(id);
        if (isdeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Student is deleted!!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse(" id not found!"));

    }


    @GetMapping("/search/{name}")
    public ResponseEntity searchStudent(@PathVariable String name){
        return studentService.searchStudent(name);
    }
}
