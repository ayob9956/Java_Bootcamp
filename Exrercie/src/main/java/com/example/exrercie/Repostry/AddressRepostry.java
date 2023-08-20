package com.example.exrercie.Repostry;

import com.example.exrercie.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepostry extends JpaRepository<Address,Integer> {



}
