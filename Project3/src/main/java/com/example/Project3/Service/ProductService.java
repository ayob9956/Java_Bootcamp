package com.example.Project3.Service;

import com.example.Project3.Model.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProductService {
    ArrayList<Product> products =new ArrayList<>();


    public ArrayList<Product> getProducts(){
        return products;
    }

    public void addProduct(Product product){

        products.add(product);//void becuse we want not retern anything!

    }
    public boolean updateProduct(String id,Product product){
        for (int i =0;i<products.size();i++){
            if (products.get(i).getId().equals(id)){
                products.set(i,product);
                return true;
            }
        }return false;
    }
    public boolean deleteProduct(String id){
        for (int i =0;i<products.size();i++){
            if (products.get(i).getId().equals(id)){
                products.remove(i);
                return true;
            }
        }return false;
    }
}
