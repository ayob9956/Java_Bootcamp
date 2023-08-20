package com.example.exrercie.Repostry;

import com.example.exrercie.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepostry extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);
}
