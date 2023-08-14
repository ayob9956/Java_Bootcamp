package com.example.Project3.Controller;

import com.example.Project3.ApiResponse.ApiResponse;
import com.example.Project3.Model.Merchant;
import com.example.Project3.Model.MerchantStock;
import com.example.Project3.Model.User;
import com.example.Project3.Service.MerchantService;
import com.example.Project3.Service.StockService;
import com.example.Project3.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController


@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
@Data
public class MerchantController {

    public final MerchantService merchantService;






    @GetMapping("/get")
    public ArrayList<Merchant> getMerchant(){
        return merchantService.getMerchants();
    }
    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("Merchant is added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@RequestBody @Valid Merchant merchant, @PathVariable String id, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        boolean updated = merchantService.updateMerchant(merchant,id);
        if (updated){
            return ResponseEntity.status(200).body(new ApiResponse("merchant is updated!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id of merchant not fund!"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable String id){
        boolean deleted = merchantService.deleteMerchent(id);
        if (deleted){
            return ResponseEntity.status(200).body(new ApiResponse("merchant is Deleted!"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id of merchant not fund!"));
    }




@PutMapping("/add/stock/{amount}/{merchantId}/{productId}")
public ResponseEntity addMerchantStock( MerchantStock merchantStock , @PathVariable String  merchantId , Errors errors, @PathVariable String productId ,@PathVariable Integer amount){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = merchantService.updateMerchantStock(productId, merchantId, amount);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Merchant is added"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("Merchant is Not added"));


    }


}
