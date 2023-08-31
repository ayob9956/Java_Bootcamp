package com.example.capstone2.Services;

import com.example.capstone2.Models.PropertyMangment;
import com.example.capstone2.Models.Tenants;
import com.example.capstone2.Models.User;
import com.example.capstone2.Repostry.PropertyMangmentRepostry;
import com.example.capstone2.Repostry.TenantsRepostry;
import com.example.capstone2.Repostry.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

class TenantsServiceTest {

    @InjectMocks
    private TenantsService tenantsService;

    @Mock
    private TenantsRepostry tenantRepository;

    @Mock
    private PropertyMangmentRepostry propertyMangmentRepository;
    @Mock
    private UserRepo    userRepo;



    User user;
    Tenants tenant1;

    Tenants tenant2;
    Tenants tenant3;

    Tenants tenants;

    PropertyMangment propertyMangment1;

    List<Tenants> allTenants;


    @BeforeEach
    void setUp() {
        user = new User(1, "ayoub", "Aa11223344", "USER", null, null);
        tenant1 = new Tenants("13", "ayoubayed", "2021-01-01", "2022-12-30", "3030", "15", 3000, 30000, 10000, null, user);
        tenant2 = new Tenants("14", "ali", "2021-01-01", "2023-12-30", "3030", "16", 6000, 30000, 10000, null, user);
        tenant3 = new Tenants("15", "ahmad", "2021-01-01", "2023-12-30", "3030", "17", 4000, 30000, 10000, null, user);

        propertyMangment1 = new PropertyMangment(1,"3030","saleh",50000,3000,allTenants,user);

        allTenants = new ArrayList<>();
        allTenants.add(tenant1);
        allTenants.add(tenant2);
        allTenants.add(tenant3);
    }

    @Test
    void getAll() {

        when(userRepo.findUserById(user.getId())).thenReturn(user);

        List<Tenants> tenantsList = new ArrayList<>();
        tenantsList.add(tenant1);
        tenantsList.add(tenant2);
        tenantsList.add(tenant3);
        when(tenantRepository.findAllByUser(user)).thenReturn(tenantsList);
        List<Tenants> result = tenantsService.getAll(user.getId());


        Assertions.assertEquals(allTenants.size(),result.size());

        verify(userRepo, times(1)).findUserById(user.getId());
        verify(tenantRepository, times(1)).findAllByUser(user);

    }

    @Test
    void addTenants() {
        when(userRepo.findUserById(user.getId())).thenReturn(user);

        tenant1.setRenters(propertyMangment1);
        tenantsService.addTenants(tenant1,"ayoub",null);


        verify(userRepo, times(1)).findUserById(user.getId());
        verify(tenantRepository, times(1)).save(tenant1);

    }

    @Test
    void updateTenants() {


    }
    @Test
    void deleteTenants() {
    }

    @Test
    void searchTenants() {
    }
}