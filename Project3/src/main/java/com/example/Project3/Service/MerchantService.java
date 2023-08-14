package com.example.Project3.Service;

import com.example.Project3.Model.Category;
import com.example.Project3.Model.Merchant;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantService {
    private final StockService stockService;
    private final UserService userService;
    private final ProductService productService;
    ArrayList<Merchant>  merchants = new ArrayList<>();


    public boolean buyProduct( String productId,
                               String id,
                               String merchantId) {
        int index =0;
        if (!(stockService.merchantStock.get(index).getProductId().equals(productId)&&stockService.merchantStock.get(index).getMerchantId().equals(merchantId)&&userService.users.get(index).getId().equals(id))){
            return false;
        }

        for (int i = 0; i < stockService.merchantStock.size(); i++) {
            if (!stockService.merchantStock.get(i).getProductId().equals(productId) && !stockService.merchantStock.get(i).equals(merchantId)) {
                return false;
            }}

        if (userService.users.get(index).getId().equals(id)&&userService.users.get(index).getBalnce() < productService.products.get(index).getPrice()) {
            return false;

        }
        if (userService.users.get(index).getBalnce() >= productService.products.get(index).getPrice()) {
            userService.users.get(index).setBalnce(userService.getUsers().get(index).getBalnce() - productService.getProducts().get(index).getPrice());
            stockService.merchantStock.get(index).setStock(stockService.merchantStock.get(index).getStock() - 1);
        }

        return true;
    }
    public boolean updateMerchantStock(String productId, String merchantId, Integer amount) {
        for (int i = 0; i < stockService.merchantStock.size(); i++) {
            if (stockService.merchantStock.get(i).getMerchantId().equals(merchantId)) {
                if (stockService.merchantStock.get(i).getProductId().equals(productId)) {
                    stockService.merchantStock.get(i).setStock(stockService.getMerchantStock().get(i).getStock() + amount);

                    return true;
                }
            }
        }
        return false;
    }



    public ArrayList<Merchant> getMerchants(){
        return merchants;
    }

    public void addMerchant(Merchant merchant){
        merchants.add(merchant);
    }

    public boolean updateMerchant(Merchant merchant,String id){
        for (int i =0; i<merchants.size();i++){
            if (merchants.get(i).getId().equals(id)){
                merchants.set(i,merchant);
                return true;
            }
        }return false;
    }
    public boolean deleteMerchent(String id){
        for (int i =0; i<merchants.size();i++){
            if (merchants.get(i).getId().equals(id)){
                merchants.remove(i);
                return true;
            }
        }return false;
    }


}


