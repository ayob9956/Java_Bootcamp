package com.example.securte.Controller;

import com.example.securte.APIs.ApiResponse;
import com.example.securte.Model.Todo;
import com.example.securte.Model.User;
import com.example.securte.Service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoController {

    private final TodoService todoService;


    @GetMapping("/get")
    public ResponseEntity getTodos(@AuthenticationPrincipal User user) {
        List<Todo> todos = todoService.getTodoList(user.getId());
        return ResponseEntity.status(200).body(todos);
    }

    @PostMapping("/add")
    public ResponseEntity addTodo(@RequestBody @Valid Todo todo,@AuthenticationPrincipal User user) {
        todoService.addTodo(todo, user.getId());
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTodo(@PathVariable Integer id, @RequestBody @Valid Todo todo,@AuthenticationPrincipal User user) {
        todoService.updateTodo(id, todo, user.getId() );
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTodo(@PathVariable Integer id,@AuthenticationPrincipal User user) {
        todoService.removeTodo(id,user.getId()  );
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("deleted successfully"));
    }

    @GetMapping("/search/{title}")
    public ResponseEntity findTodoByTitle(@PathVariable String title) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.findTodoByTitle(title));


    }


}
