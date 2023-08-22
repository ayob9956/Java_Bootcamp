package com.example.exrercie.Controller;

import com.example.exrercie.ApiResponse.ApiResponse;
import com.example.exrercie.Service.CourseService;
import jakarta.validation.Valid;
import com.example.exrercie.Models.Course;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService couserService;

    @GetMapping("/get")
    public ResponseEntity getCourses(){
        return ResponseEntity.status(200).body(couserService.getCourse());
    }
    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        couserService.addCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("course added"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        couserService.deleteeCourse(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("course deleted"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id ,@RequestBody @Valid Course course){
        couserService.updateCourse(id, course);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("course updated"));
    }
    @GetMapping("/{cId}/assign/{Tid}")
    public ResponseEntity assignCourse(@PathVariable Integer cId,@PathVariable Integer Tid){
        couserService.assignCourseToTeacher(Tid, cId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("course assigned"));
    }
    @GetMapping("/search/{cId}")
    public ResponseEntity searchCourse(@PathVariable Integer cId){
        return ResponseEntity.status(HttpStatus.OK).body(couserService.searchById(cId));
    }
}
