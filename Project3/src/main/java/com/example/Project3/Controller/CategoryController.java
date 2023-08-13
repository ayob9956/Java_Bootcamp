package com.example.Project3.Controller;

import com.example.Project3.ApiResponse.ApiResponse;
import com.example.Project3.Model.Category;
import com.example.Project3.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RequestMapping("/api/v1/category")
@RestController
@Data
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get")
    public ArrayList<Category> getCategory(){
       return categoryService.getCategories();
    }

    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(200).body(new ApiResponse("Category is Added!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory(@RequestBody @Valid Category category,@PathVariable String id,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryService.updateCatogery(category,id);
        boolean isupdated = categoryService.updateCatogery(category,id);
        if (isupdated){
            return ResponseEntity.status(200).body(new ApiResponse("Category is updated!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id of Category not fund!"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id){
        boolean isdeleted = categoryService.deleteCatogery(id);
        if (isdeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Category is updated!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id of Category not fund!"));
    }
}
