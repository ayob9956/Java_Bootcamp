package com.example.securte.Service;


import com.example.securte.Model.User;
import com.example.securte.Repostry.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

private final UserRepo userRepo;

    public void register(User user){
        String hash = new BCryptPasswordEncoder().encode(user.getPassword());

        user.setPassword(hash);
        user.setRole("USER");

        userRepo.save(user);
    }


//    public List<User> getAllUsers(){
//        return userRepo.findAll();
//    }


//    public ResponseEntity

}
