package com.example.exrercie.Controller;


import com.example.exrercie.Models.Teacher;
import com.example.exrercie.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(200).body(teacherService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher is add");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@RequestBody @Valid Teacher teacher, @PathVariable Integer id){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body("Teacher is Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher is deleted");
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity searchTeacher(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.searchTeacher(id));
    }
}
