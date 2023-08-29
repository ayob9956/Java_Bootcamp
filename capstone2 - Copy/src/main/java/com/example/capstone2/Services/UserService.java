package com.example.capstone2.Services;

import com.example.capstone2.Models.User;
import com.example.capstone2.Repostry.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepo userRepository;


    public void registerUser(User user){
        String hash = new BCryptPasswordEncoder().encode(user.getPassword());

        user.setPassword(hash);
        user.setRole("User");


        userRepository.save(user);
    }
}
