package com.example.Project3.Service;

import com.example.Project3.Model.Category;
import com.example.Project3.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {

    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers(){
        return users;
    }
    public void addUser(User user){
        users.add(user);
    }

    public boolean updateUser(User user, String id){
        for (int i =0; i<users.size();i++){
            if (users.get(i).getId().equals(id)){
                users.set(i,user);
                return true;
            }
        }return false;
    }
    public boolean deleteUser(String id){
        for (int i =0; i<users.size();i++){
            if (users.get(i).getId().equals(id)){
                users.remove(i);
                return true;
            }
        }return false;
    }
}
