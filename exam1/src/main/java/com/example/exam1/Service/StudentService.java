package com.example.exam1.Service;

import com.example.exam1.ApiResponse.ApiResponse;
import com.example.exam1.Model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Student> getStudents(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public boolean updateStudent(Student student,String id){
        for (int i =0 ; i<students.size();i++){
            if (students.get(i).getId().equals(id)){
                students.set(i,student);
                return true;
            }

        } return false;
    }

    public boolean deleteStudent(String id){
        for (int i =0 ; i<students.size();i++){
            if (students.get(i).getId().equals(id)){
                students.remove(i);
                return true;
            }

        } return false;
    }


    public ResponseEntity searchStudent(String id){
        for (int i =0 ; i<students.size();i++){
                if (students.get(i).getId().equals(id)){
                return ResponseEntity.status(200).body(students.get(i));
            }
        } return ResponseEntity.status(400).body(new ApiResponse("id not fond!"));
    }
}
