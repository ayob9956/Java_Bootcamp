package com.example.exam1.Service;

import com.example.exam1.ApiResponse.ApiResponse;
import com.example.exam1.Model.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher> teachers= new ArrayList<>();
    public ArrayList<Teacher> getTeachers(){
        return teachers;
    }

    public void addTeachers(Teacher teacher){
        teachers.add(teacher);
    }

    public boolean updateTeacher(Teacher teacher,String id){
        for (int i =0 ; i<teachers.size();i++){
            if (teachers.get(i).getId().equals(id)){
                    teachers.set(i,teacher);
                return true;
            }

        } return false;
    }


    public boolean deleteTeacher(String id){
        for (int i =0 ; i<teachers.size();i++){
            if (teachers.get(i).getId().equals(id)){
                teachers.remove(i);
                return true;
            }

        } return false;
    }


    public ResponseEntity searchTeacher(String id){
        for (int i =0 ; i<teachers.size();i++){
            if (teachers.get(i).getId().equals(id)){
                return ResponseEntity.status(200).body(teachers.get(i));
            }
    } return ResponseEntity.status(400).body(new ApiResponse("id not fond!"));
}}
