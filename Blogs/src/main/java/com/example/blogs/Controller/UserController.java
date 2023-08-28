package com.example.blogs.Controller;

import com.example.blogs.Apis.ApiResponse;
import com.example.blogs.Model.User;
import com.example.blogs.Repo.UserRepo;
import com.example.blogs.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
