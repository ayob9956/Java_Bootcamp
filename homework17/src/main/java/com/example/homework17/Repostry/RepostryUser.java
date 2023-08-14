package com.example.homework17.Repostry;

import com.example.homework17.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepostryUser  extends JpaRepository<User,Integer> {
}
