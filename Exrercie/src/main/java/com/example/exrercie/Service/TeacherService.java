package com.example.exrercie.Service;

import com.example.exrercie.ApiException.ApiExceptions;
import com.example.exrercie.Models.Teacher;
import com.example.exrercie.Repostry.AddressRepostry;
import com.example.exrercie.Repostry.TeacherRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepostry teacherRepostry;
    private final AddressRepostry addressRepostry;

    public List<Teacher> getAll() {
        return teacherRepostry.findAll();
    }

    public void  addTeacher(Teacher teacher){
        teacherRepostry.save(teacher);
    }

    public  void  updateTeacher(Integer id,Teacher teacher){
        Teacher teacher1 = teacherRepostry.findTeacherById(id);

        if (teacher1 == null){
            throw new ApiExceptions("id not found");

        }
        teacher1.setAddress(teacher.getAddress());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setName(teacher1.getName());
        teacher1.setSalary(teacher.getSalary());

        teacherRepostry.save(teacher1);
    }


    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepostry.findTeacherById(id);
        addressRepostry.delete(teacher.getAddress());
        teacherRepostry.delete(teacher);
    }

    public Teacher searchTeacher(Integer id){
        Teacher teacher=teacherRepostry.findTeacherById(id);
        return teacher;
    }
}
