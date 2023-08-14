package com.example.Project3.Controller;

import com.example.Project3.ApiResponse.ApiResponse;
import com.example.Project3.Model.Category;
import com.example.Project3.Model.MerchantStock;
import com.example.Project3.Model.User;
import com.example.Project3.Service.StockService;
import com.example.Project3.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;





    @GetMapping("/get")
public ArrayList<User> getUsers(){
    return userService.getUsers();
}
@PostMapping("/add")
public ResponseEntity addUser(@RequestBody @Valid User user ,Errors errors){
    if (errors.hasErrors()){
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    userService.addUser(user);
    return ResponseEntity.status(200).body(new ApiResponse("User is added"));

}


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody @Valid User user, @PathVariable String id, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean updated = userService.updateUser(user,id);
        if (updated){
            return ResponseEntity.status(200).body(new ApiResponse("User is updated!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id of User not fund!"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        boolean deleted = userService.deleteUser(id);
        if (deleted){
            return ResponseEntity.status(200).body(new ApiResponse("User is updated!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id of User not fund!"));
    }

    @GetMapping("/buy/{id}/{merchantId}/{productId}")
public ResponseEntity buyProduct(  User user,
                                  @PathVariable  String id,
                                   MerchantStock merchantStock,
                                  @PathVariable  String merchantId,
                                  @PathVariable  String productId,

                                 Errors errors ){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean haveProduct = userService.buyProduct(productId,id,merchantId);
        System.out.println(haveProduct);
        if (haveProduct){
            return ResponseEntity.status(200).body(new ApiResponse("nice to sell you"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("check your data!!"));

}

    @GetMapping("/serch/{username}")
    public ResponseEntity serchUser(@PathVariable("username") String username){

        if (userService.serchUser(username)!=null){




            return ResponseEntity.status(200).body(userService.serchUser(username));
        }

        return ResponseEntity.status(400).body(new ApiResponse("user not found!!"));

    }
}
