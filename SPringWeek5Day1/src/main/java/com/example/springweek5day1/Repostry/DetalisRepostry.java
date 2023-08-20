package com.example.springweek5day1.Repostry;

import com.example.springweek5day1.Models.Detalis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalisRepostry extends JpaRepository<Detalis,Integer> {
}
