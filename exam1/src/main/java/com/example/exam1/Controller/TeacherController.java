package com.example.exam1.Controller;

import com.example.exam1.ApiResponse.ApiResponse;
import com.example.exam1.Model.Student;
import com.example.exam1.Model.Teacher;
import com.example.exam1.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    public final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getStudent(){
        if (teacherService.getTeachers()==null){
            return ResponseEntity.status(400).body(new ApiResponse("Student class is null!"));
        }
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addteacher(@RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        teacherService.addTeachers(teacher);
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    public ResponseEntity updateTeacher(@RequestBody @Valid Teacher teacher,String id,Errors errors){
        if (errors.hasErrors()){
            String message  = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean isupdeted =  teacherService.updateTeacher(teacher,id);
        if (isupdeted){
            return ResponseEntity.status(200).body(new ApiResponse("Student is updated!!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse(" id not found!"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(
            @PathVariable String id
    ){

        boolean isdeleted = teacherService.deleteTeacher(id);
        if (isdeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Student is deleted!!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse(" id not found!"));

    }

    @GetMapping("/search/{id}")
    public ResponseEntity searchTeacher(@PathVariable String id){
        return teacherService.searchTeacher(id);
    }

    }

