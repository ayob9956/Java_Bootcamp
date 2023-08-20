package com.example.springweek5day1.Service;


import com.example.springweek5day1.ApiException.ApiExceptions;
import com.example.springweek5day1.Models.Customer;
import com.example.springweek5day1.Repostry.CustomerRepostry;
import com.example.springweek5day1.Repostry.DetalisRepostry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepostry customerRepostry;
    private final DetalisRepostry detalisRepostry;


    public List<Customer> getAll(){
        return customerRepostry.findAll();
    }

    public void  addCustomer(Customer customer){
        customerRepostry.save(customer);
    }

    public void  updateCustomer(Integer id,Customer customer){
        Customer customer1=customerRepostry.getById(id);
        if (customer1 == null){
            throw new ApiExceptions("customer is not found");
        }
        customer1.setName(customer.getName());
        customerRepostry.save(customer1);
    }



    public void deleteCUstomer(Integer id){
        Customer customer1=customerRepostry.findCustomerById(id);
        if (customer1 == null){
            throw new ApiExceptions("customer is not found");
        }
        detalisRepostry.deleteById(customer1.getId());
        customerRepostry.delete(customer1);

    }
}
