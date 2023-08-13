package com.example.Project3.Controller;

import com.example.Project3.ApiResponse.ApiResponse;
import com.example.Project3.Model.Product;
import com.example.Project3.Service.ProductService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;


    @GetMapping("/get")
    public ArrayList<Product> getProduct(){
        return productService.getProducts();
    }
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        productService.addProduct(product);
        return ResponseEntity.status(200).body(new ApiResponse("Prodcut is Added!"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@RequestBody @Valid Product product,@PathVariable String id, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isUpdated=productService.updateProduct(id, product);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Prodcut is updated!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("ID IS NOT FOUND!!!"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        boolean isdeleted = productService.deleteProduct(id);
        if (isdeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Product is deleted!!!"));
        }        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("ID IS NOT FOUND!!!"));

    }


}
