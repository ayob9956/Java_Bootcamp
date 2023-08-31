package com.example.capstone2.Repostry;

import com.example.capstone2.Models.Tenants;
import com.example.capstone2.Models.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TenantsRepostryTest {

    @Autowired
    TenantsRepostry tenantsRepository;

    User user;
    Tenants tenant1;

    Tenants tenant2;
    Tenants tenant3;

    Tenants tenants;


    List<Tenants> allTenants;


    @BeforeEach
    void setUp() {
        user = new User(1, "ayoub", "Aa11223344", "USER", null, null);
        tenant1 = new Tenants("13", "ayoub", "2021-01-01", "2022-12-30", "3030", "15", 3000, 30000, 10000, null, user);
        tenant2 = new Tenants("14", "ali", "2021-01-01", "2023-12-30", "3030", "16", 6000, 30000, 10000, null, user);
        tenant3 = new Tenants("15", "ahmad", "2021-01-01", "2023-12-30", "3030", "17", 4000, 30000, 10000, null, user);


    }

    @Test
    public void findAllByUser() {
        tenantsRepository.save(tenant1);
        tenantsRepository.save(tenant2);
        tenantsRepository.save(tenant3);

        allTenants = tenantsRepository.findAllByUser(user);

    }

    @Test
    public void findByContract() {
        tenantsRepository.save(tenant1);

        tenants = tenantsRepository.findByContract(tenant1.getContract());
        Assertions.assertThat(tenants.equals(tenant1));

    }

    @Test
    void findAllByBuildingcode() {
        tenantsRepository.save(tenant1);
        tenantsRepository.save(tenant2);
        tenantsRepository.save(tenant3);

        allTenants = tenantsRepository.findAllByBuildingcode(tenant1.getBuildingcode());
        Assertions.assertThat(allTenants.get(0).getBuildingcode()).isEqualTo(tenant1.getBuildingcode());;
    }

    @Test
    void findAllByEnddateAfter() {
        tenantsRepository.save(tenant1);
        tenantsRepository.save(tenant2);
        tenantsRepository.save(tenant3);
        allTenants = tenantsRepository.findAllByEnddateAfter(tenant1.getEnddate());

        Assertions.assertThat(allTenants.get(0).getEnddate()).isGreaterThan(tenant1.getEnddate());
    }

    @Test
    void findByPriceInRange() {
        tenantsRepository.save(tenant1);
        tenantsRepository.save(tenant2);
        tenantsRepository.save(tenant3);

        allTenants = tenantsRepository.findByPriceInRange(tenant1.getPrice(), tenant2.getPrice());

        Assertions.assertThat(allTenants.get(0).getPrice()).isBetween(tenant1.getPrice(), tenant2.getPrice());
//        Assertions.assertThat(allTenants.get(0).getPrice()).isGreaterThan(tenant1.getPrice());
//        Assertions.assertThat(allTenants.get(0).getPrice()).isLessThan(tenant2.getPrice());
    }
}