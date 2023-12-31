package com.example.capstone2.Controllers;

import com.example.capstone2.ApiResponse.ApiResponse;
import com.example.capstone2.Models.Tenants;
import com.example.capstone2.Models.User;
import com.example.capstone2.Repostry.TenantsRepostry;
import com.example.capstone2.Services.TenantsService;
import jakarta.persistence.PersistenceUnit;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tenants")
@RequiredArgsConstructor
public class TenantsController {

    private final TenantsService tenantsService;

    @GetMapping("/get")
    public ResponseEntity getAll(@AuthenticationPrincipal User user) {
        return ResponseEntity.status(200).body(tenantsService.getAll(user.getId()));
    }

    @PostMapping("/add/{renters_id}")
    public ResponseEntity addTenant(@RequestBody @Valid Tenants tenants, @AuthenticationPrincipal User user,@PathVariable Integer renters_id ) {

        tenantsService.addTenants(tenants, user.getUsername(),renters_id);

        return ResponseEntity.status(200).body(new ApiResponse("is add"));
    }

    @PutMapping("/update/{contract}")
    public ResponseEntity updatetenants(@RequestBody @Valid Tenants tenants, @PathVariable String contract , @AuthenticationPrincipal User user) {
        tenantsService.updateTenants(contract, tenants, user.getUsername());
        return ResponseEntity.status(200).body(new ApiResponse("tenants is updated"));
    }

    @DeleteMapping("/delete/{contract}")
    public ResponseEntity deleteTenants(@PathVariable String contract,@AuthenticationPrincipal User user) {
        tenantsService.deleteTenants(contract, user.getUsername());
        return ResponseEntity.status(200).body(new ApiResponse("Tanant is deleted"));

    }

    @GetMapping("/search/{buildingcode}")
    public ResponseEntity searchTenants(@PathVariable String buildingcode,@AuthenticationPrincipal User user) {

        List<Tenants> tenants = tenantsService.searchTenants(buildingcode);
        return ResponseEntity.status(200).body(tenants);
    }

    @GetMapping("/searchenddate/{enddate}")
    public ResponseEntity searchTenantsEndDate(@PathVariable String enddate) {
        List<Tenants> tenants = tenantsService.searchTenantsEndDate(enddate);

        return ResponseEntity.status(200).body(tenants);
    }


    @GetMapping("/search")
    public List<Tenants> getPropertiesInPriceRange(@RequestParam("minPrice") Integer minPrice, @RequestParam("maxPrice") Integer maxPrice) {
        return tenantsService.searchPriceInRange(minPrice, maxPrice);

    }

// هذي مرحلة الدفع
    @PutMapping("/rent/{contract}")
    public ResponseEntity rentFlate(@PathVariable String contract) {
        Tenants tenants = tenantsService.searchByContract(contract);
        tenantsService.rentFlate(contract, tenants);
        return ResponseEntity.status(200).body("jk");

    }
// هذي في حال المستأجر طلب صيانة
    @PutMapping("/domatinance/{contract}/{mant}")
    public ResponseEntity domatinance(@PathVariable String contract,@PathVariable Integer mant) {
        Tenants tenants = tenantsService.searchByContract(contract);
        tenantsService.domatinance(contract, tenants,mant);
        return ResponseEntity.status(200).body(tenants);

    }
    @GetMapping("/contractextension/{contract}/{enddate}/{startdate}")
    public ResponseEntity ContractExtension(@PathVariable String contract,@PathVariable String enddate,@PathVariable String startdate) {
        Tenants tenants = tenantsService.searchByContract(contract);
        tenantsService.ContractExtension(contract, enddate,startdate);
        return ResponseEntity.status(200).body("Contract is Extension");

    }


}
