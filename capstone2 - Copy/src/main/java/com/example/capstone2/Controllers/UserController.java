package com.example.capstone2.Controllers;

import com.example.capstone2.ApiResponse.ApiResponse;
import com.example.capstone2.Models.User;
import com.example.capstone2.Services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {


    private final UserService userService;



    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody @Valid User user) {


        userService.registerUser(user);

        return ResponseEntity.status(200).body(new ApiResponse("User registered successfully"));
    }

    @GetMapping("/logout")
    public ResponseEntity logout(){
        return ResponseEntity.status(200).body("logout successfully");
    }

}
