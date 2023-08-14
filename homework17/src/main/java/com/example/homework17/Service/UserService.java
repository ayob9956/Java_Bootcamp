package com.example.homework17.Service;

import com.example.homework17.Model.User;
import com.example.homework17.Repostry.RepostryUser;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
@Autowired
private final RepostryUser repostryUser;


    public List<User> getUsers() {
        return repostryUser.findAll();
    }

    public Boolean addUsers(User user) {

        repostryUser.save(user);
        return true;
    }
    public Boolean deleteUser(Integer id){
        User removeUser = repostryUser.getById(id);
        if(removeUser == null){
            return false;
        }
        repostryUser.delete(removeUser);
        return true;

    }


    public Boolean updateUser(User user , Integer id){
        User updated = repostryUser.getById(id);
        if (updated == null){
            return false;
        }
        updated.setAge(user.getAge());
        updated.setName(user.getName());
        repostryUser.save(updated);
        return true;
    }


}
