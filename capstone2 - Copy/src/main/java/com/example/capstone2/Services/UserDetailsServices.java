package com.example.capstone2.Services;


import com.example.capstone2.ApiResponse.ApiException;
import com.example.capstone2.Models.User;
import com.example.capstone2.Repostry.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServices implements UserDetailsService {

    private final UserRepo userRepoo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepoo.findUserByUsername(username);
        if (user == null) {
            throw new ApiException("User not found");
        }
        return user;
    }
}
