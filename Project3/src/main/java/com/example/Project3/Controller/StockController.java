package com.example.Project3.Controller;

import com.example.Project3.ApiResponse.ApiResponse;
import com.example.Project3.Model.Merchant;
import com.example.Project3.Model.MerchantStock;
import com.example.Project3.Service.MerchantService;
import com.example.Project3.Service.StockService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/stock")
@AllArgsConstructor
public class StockController {
    private final StockService stockService;




    @GetMapping("/get")
    public ArrayList<MerchantStock> getMerchantStock(){
        return stockService.getMerchantStock();
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid MerchantStock merchantStock , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        stockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body(new ApiResponse("Merchant is added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@RequestBody @Valid MerchantStock merchantStock, @PathVariable String id, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean updated = stockService.updateMerchantStock(merchantStock,id);
        if (updated){
            return ResponseEntity.status(200).body(new ApiResponse("merchant is updated!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id of merchant not fund!"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable String id){
        boolean deleted = stockService.deleteMerchentStock(id);
        if (deleted){
            return ResponseEntity.status(200).body(new ApiResponse("merchant is Deleted!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id of merchant not fund!"));
    }


    @GetMapping("/serch/{productId}")
    public ResponseEntity serchProduct(@PathVariable("productId") String productId){

        if (stockService.searchStock(productId)==null){

            return ResponseEntity.status(400).body(new ApiResponse("Stock not found!!"));



        }
        return ResponseEntity.status(200).body(stockService.searchStock(productId));

    }


}
