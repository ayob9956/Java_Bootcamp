package com.example.capstone2.Repostry;

import com.example.capstone2.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
    User findUserById(Integer id);
    User findUserByRole(String role);
}
