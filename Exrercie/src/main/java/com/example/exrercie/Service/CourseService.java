package com.example.exrercie.Service;

import com.example.exrercie.ApiException.ApiExceptions;
import com.example.exrercie.Models.Course;
import com.example.exrercie.Models.Teacher;
import com.example.exrercie.Repostry.CourseReposetry;
import com.example.exrercie.Repostry.TeacherRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

        private final CourseReposetry courseReposetry;
        private final TeacherRepostry teacherReposetry;

        public List<Course> getCourse() {
            return courseReposetry.findAll();
        }
        public void addCourse(Course course) {
            courseReposetry.save(course);
        }

        public void deleteeCourse(Integer id) {
            Course course = courseReposetry.findCourseById(id);
            if(course == null){
                throw new ApiExceptions("Course not found");
            }
            courseReposetry.delete(course);
        }

        public void updateCourse(Integer id ,Course course){
            Course course1 = courseReposetry.findCourseById(id);
            if(course == null){
                throw new ApiExceptions("Course not found");
            }
            course1.setName(course.getName());
            course1.setTeacher(course.getTeacher());
            courseReposetry.save(course1);
        }

        public void assignCourseToTeacher(Integer tid,Integer cid){
            Teacher teacher = teacherReposetry.findTeacherById(tid);
            Course course1 = courseReposetry.findCourseById(cid);
            if(teacher == null || course1 == null){
                throw new ApiExceptions("Can not assign");
            }
            course1.setTeacher(teacher);
            courseReposetry.save(course1);
        }

        public String  searchById(Integer id){
            Course course = courseReposetry.findCourseById(id);
            if(course == null){
                throw new ApiExceptions("Course not found");
            }
            return course.getTeacher().getName();
        }

    }

