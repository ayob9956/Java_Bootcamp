package com.example.springweek5day1.Service;


import com.example.springweek5day1.DTO.CustomerDTO;
import com.example.springweek5day1.Models.Customer;
import com.example.springweek5day1.Models.Detalis;
import com.example.springweek5day1.Repostry.CustomerRepostry;
import com.example.springweek5day1.Repostry.DetalisRepostry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class DetailsService {
    private final CustomerRepostry customerRepostry;
    private final DetalisRepostry detalisRepostry;

    public void addDetails(CustomerDTO customerDTO) {
        Customer customer = customerRepostry.findCustomerById(customerDTO.getCustomer_id());

        Detalis detalis = new Detalis(null, customerDTO.getGender(), customerDTO.getAge(), customerDTO.getEmail(), customer);

        detalisRepostry.save(detalis);
    }

    public void deleteDetails(Integer customer_id){
        Customer customer=customerRepostry.findCustomerById(customer_id);
        Detalis detalis = customer.getDetalis();

        detalisRepostry.delete(detalis);

    }


    public void updateDetails(Integer customer_id,CustomerDTO customerDTO){
        Customer customer=customerRepostry.findCustomerById(customer_id);
        Detalis detalis = customer.getDetalis();
        detalis.setGender(customerDTO.getGender());
        detalis.setAge(customerDTO.getAge());

        detalis.setEmail(customerDTO.getEmail());

        detalisRepostry.save(detalis);


    }
}
