package com.example.securte.Repostry;

import com.example.securte.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
    User findUserById(Integer id);
}
