package com.example.securte.Controller;


import com.example.securte.APIs.ApiResponse;
import com.example.securte.Model.User;
import com.example.securte.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

//    @GetMapping("/get")
//    public ResponseEntity getAll(){
//        return ResponseEntity.status(200).body(authService.getAllUsers());
//    }
    @PostMapping("/regester")
    public ResponseEntity regester(@RequestBody User user) {


       authService.register(user);

       return ResponseEntity.status(200).body(new ApiResponse("User registered successfully"));
    }

    public ResponseEntity logout(){
        return ResponseEntity.status(200).body("logout successfully");
    }

}
