package com.example.blogs.Service;

import com.example.blogs.Apis.ApiException;
import com.example.blogs.Model.User;
import com.example.blogs.Repo.UserRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServices implements org.springframework.security.core.userdetails.UserDetailsService {

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
