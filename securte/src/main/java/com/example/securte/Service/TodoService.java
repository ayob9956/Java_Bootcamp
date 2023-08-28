package com.example.securte.Service;

import com.example.securte.APIs.ApiException;
import com.example.securte.Model.Todo;
import com.example.securte.Model.User;
import com.example.securte.Repostry.TodoRepo;
import com.example.securte.Repostry.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@RequiredArgsConstructor
public class TodoService {



        private final TodoRepo todoRepository;
        private final UserRepo userRepository;

        public List<Todo> getTodoList(Integer user_id) {

            User user = userRepository.findUserById(user_id);
            return todoRepository.findAllByUser(user);
        }

        public void addTodo(Todo todo,Integer UserId) {
           User user = userRepository.findUserById(UserId);

           todo.setUser(user);
            todoRepository.save(todo);
        }

        public void removeTodo(Integer id,Integer Userid) {
            User user = userRepository.findUserById(Userid);
            Todo todo = todoRepository.findTodoById(id);
            if (todo == null || todo.getUser() == user) {
                throw new ApiException("Todo not found: " + id +" user id not found: " + id);
            }
            todoRepository.delete(todo);
        }

    public void updateTodo(Integer id, Todo todo,Integer UserId) {
        Todo todo1 = todoRepository.findTodoById(id);
        User user = userRepository.findUserById(UserId);
        if (todo1 == null || user == null) {
            throw new ApiException("Todo not found: " + id +" user id not found: " + id);
        }
        todo1.setTitle(todo.getTitle());
        todoRepository.save(todo1);
    }

    public Todo findTodoByTitle(String title) {
        Todo todos = todoRepository.findTodoByTitle(title);
        if (todos == null) {
            throw new ApiException("Todo not found: " + title);
        }
        return todos;
    }






}
