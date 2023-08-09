package com.example.homework13p2.Controller;

import com.example.homework13p2.Model.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank/mangment")
public class CustomersController {
    ArrayList<Customers> customers = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customers> getCustomers(){
        return customers;
    }

    @PostMapping(path = "/add/new")
    public String addNewCustomers(@RequestBody Customers customer ){
        customers.add(customer);
        return "Customers is add!";

    }
    @PutMapping("/update/{index}")
    public String updateCustomer(@RequestBody Customers customer,@PathVariable int index){
    customers.set(index,customer);
    return "Customers is updated!";

    }

    @DeleteMapping("/delete/{index}")
    public String removeCusttomer(@PathVariable int index){
        customers.remove(index);
        return "Customer is removed!";
    }

    @PutMapping("/deposit/{id}/{amount}")
    public ArrayList<Customers> deposit(@PathVariable String id,@PathVariable int amount){

        for (Customers c:customers) {


        if (c.getId().equalsIgnoreCase(id)){

            c.setBalnce(c.getBalnce()+amount);
            return customers;
        }else{


            return customers;
        }}return customers;

    }
    @PutMapping("/withdraw/{id}/{amount}")
public ArrayList<Customers> withdraw(@PathVariable String id , @PathVariable int amount){
    for (Customers c:customers) {
        if (c.getId().equalsIgnoreCase(id) && c.getBalnce() > amount ){
            c.setBalnce(c.getBalnce()-amount);
            return customers;
        }

    }
    return null;
}

}
