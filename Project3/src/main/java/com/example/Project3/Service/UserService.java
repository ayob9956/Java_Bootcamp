package com.example.Project3.Service;

import com.example.Project3.Model.Category;
import com.example.Project3.Model.MerchantStock;
import com.example.Project3.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
private final StockService stockService;
private final ProductService productService;
    ArrayList<User> users = new ArrayList<>();



    public boolean buyProduct( String productId,
                               String id,
                               String merchantId) {
        int index =0;
        if (!(stockService.merchantStock.get(index).getProductId().equals(productId)&&stockService.merchantStock.get(index).getMerchantId().equals(merchantId)&& users.get(index).getId().equals(id))){
            return false;
        }

        for (int i = 0; i < stockService.merchantStock.size(); i++) {
            if (!stockService.merchantStock.get(i).getProductId().equals(productId) && !stockService.merchantStock.get(i).equals(merchantId)) {
                return false;
            }}

        if (users.get(index).getId().equals(id)&&users.get(index).getBalnce() < productService.products.get(index).getPrice()) {
            return false;

        }
        if (users.get(index).getBalnce() >= productService.products.get(index).getPrice()) {
            users.get(index).setBalnce(getUsers().get(index).getBalnce() - productService.getProducts().get(index).getPrice());
            stockService.merchantStock.get(index).setStock(stockService.merchantStock.get(index).getStock() - 1);
        }

        return true;
    }

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

//
    public User serchUser(String username){
        for (User user : users) {
            if (user.getUsername().equals(username)) {

                return user;
            }
        }
        return null;
    }

}
