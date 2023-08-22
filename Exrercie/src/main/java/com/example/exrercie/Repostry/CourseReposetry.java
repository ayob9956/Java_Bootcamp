package com.example.exrercie.Repostry;

import com.example.exrercie.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseReposetry extends JpaRepository<Course,Integer> {
    Course findCourseById(Integer id);
}