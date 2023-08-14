package com.example.Project3.Service;

import com.example.Project3.ApiResponse.ApiResponse;
import com.example.Project3.Model.MerchantStock;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class StockService {

    public final ProductService productService;
    ArrayList<MerchantStock> merchantStock = new ArrayList<>();

//    private final StockService stockService;


    public ArrayList<MerchantStock> getMerchantStock() {
        return merchantStock;
    }

    public void addMerchantStock(MerchantStock merchantStock1) {
        merchantStock.add(merchantStock1);
    }


    public boolean updateMerchantStock(MerchantStock merchantStock1, String id) {
        for (int i = 0; i < merchantStock.size(); i++) {
            if (merchantStock.get(i).getId().equals(id)) {
                merchantStock.set(i, merchantStock1);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchentStock(String id) {
        for (int i = 0; i < merchantStock.size(); i++) {
            if (merchantStock.get(i).getId().equals(id)) {
                merchantStock.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateMerchantStock(String productId, String merchantId, Integer amount) {
        for (int i = 0; i < merchantStock.size(); i++) {
            if (merchantStock.get(i).getMerchantId().equals(merchantId)) {
                if (merchantStock.get(i).getProductId().equals(productId)) {
                    merchantStock.get(i).setStock(getMerchantStock().get(i).getStock() + amount);

                    return true;
                }
            }
        }
        return false;
    }

    public MerchantStock searchStock(String productId){
        for (int i =0; i <merchantStock.size();i++){
            if (merchantStock.get(i).getProductId().equals(productId)){

                return merchantStock.get(i) ;
            }
        }
        return null;
    }

}
