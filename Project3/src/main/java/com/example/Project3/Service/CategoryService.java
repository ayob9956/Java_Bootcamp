package com.example.Project3.Service;

import com.example.Project3.Model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CategoryService {
    ArrayList<Category> categories = new ArrayList<>();


    public ArrayList<Category> getCategories(){
        return categories;
    }

    public void addCategory(Category category){
        categories.add(category);
    }

    public boolean updateCatogery(Category category,String id){
        for (int i =0; i<categories.size();i++){
            if (categories.get(i).getId().equals(id)){
                categories.set(i,category);
                return true;
            }
        }return false;
    }
    public boolean deleteCatogery(String id){
        for (int i =0; i<categories.size();i++){
            if (categories.get(i).getId().equals(id)){
                categories.remove(i);
                return true;
            }
        }return false;
    }
}
