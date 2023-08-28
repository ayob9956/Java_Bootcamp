package com.example.securte.Service;

import com.example.securte.APIs.ApiException;
import com.example.securte.Model.User;
import com.example.securte.Repostry.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDEtailsService implements UserDetailsService {

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
