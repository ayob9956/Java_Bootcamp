package com.example.springweek5day1.Repostry;

import com.example.springweek5day1.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepostry extends JpaRepository<Customer,Integer> {



    Customer findCustomerById(Integer customerId);
}
