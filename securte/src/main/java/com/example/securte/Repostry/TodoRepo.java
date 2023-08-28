package com.example.securte.Repostry;

import com.example.securte.Model.Todo;
import com.example.securte.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Repository
public interface TodoRepo extends JpaRepository<Todo,Integer> {

    List<Todo> findAllByUser(User user);
    Todo findTodoByTitle(String title);
    Todo findTodoById(Integer id);
}
