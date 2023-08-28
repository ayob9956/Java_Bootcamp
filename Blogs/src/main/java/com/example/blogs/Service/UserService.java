package com.example.blogs.Service;

import com.example.blogs.Model.User;
import com.example.blogs.Repo.UserRepo;
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


        userRepository.save(user);
    }
}
