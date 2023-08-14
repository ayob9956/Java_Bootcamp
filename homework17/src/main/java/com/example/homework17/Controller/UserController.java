package com.example.homework17.Controller;

import com.example.homework17.ApiRespons.ApiResponse;
import com.example.homework17.Model.User;
import com.example.homework17.Repostry.RepostryUser;
import com.example.homework17.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userr")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    public  UserService userService;

    @GetMapping("/get")
   public List<User> getAllUsers(){
       return userService.getUsers();
   }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        Boolean added = userService.addUsers(user);
       if (added){
           return ResponseEntity.status(200).body(new ApiResponse("user is added"));
       }
       return ResponseEntity.status(400).body(new ApiResponse("check your data"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody @Valid User user, Integer id, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        Boolean updated= userService.updateUser(user,id);
        if (updated){
            return ResponseEntity.status(200).body(new ApiResponse("User is updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
    Boolean deleted = userService.deleteUser(id);
    if (deleted){
        return ResponseEntity.status(200).body(new ApiResponse("User is deleted"));

    }return ResponseEntity.status(400).body(new ApiResponse("id is not found"));
    }
}
