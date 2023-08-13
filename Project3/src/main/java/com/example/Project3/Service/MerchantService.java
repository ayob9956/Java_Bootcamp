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
    ArrayList<Merchant>  merchants = new ArrayList<>();

    public final StockService stockService;


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


