package com.example.capstone2.Controllers;

import com.example.capstone2.Models.PropertyMangment;
import com.example.capstone2.Models.Tenants;
import com.example.capstone2.Models.User;
import com.example.capstone2.Services.TenantsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TenantsController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
class TenantsControllerTest {

    @MockBean
    private TenantsService tenantService;

    @Autowired
    private MockMvc mockMvc;


    User user;
    Tenants tenant1;
    Tenants tenant2;

    Tenants tenant3;

    PropertyMangment propertyMangment1;
    List<Tenants> tenants;


    @BeforeEach
    void setUp() {
        user = new User(1, "Ayoub", "Aa11223344", "USER", null, null);

        tenant1 = new Tenants("13", "ayoubayed", "2021-01-01", "2022-12-30", "3030", "15", 3000, 30000, 10000, null, user);
        tenant2 = new Tenants("14", "ali", "2021-01-01", "2023-12-30", "3030", "16", 6000, 30000, 10000, null, user);
        tenant3 = new Tenants("15", "ahmad", "2021-01-01", "2023-12-30", "3030", "17", 4000, 30000, 10000, null, user);

        propertyMangment1 = new PropertyMangment(1, "3030", "saleh", 50000, 3000, null, user);

        tenants = new ArrayList<>();
        tenants.add(0, tenant1);
        tenants.add(1, tenant2);
    }

    @Test
    void getAll() throws Exception {

        when(tenantService.getAll(user.getId())).thenReturn(tenants);
        mockMvc.perform(get("/api/v1/tenants/get"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0)));

    }

    @Test
    void addTenant() throws Exception {

        when(tenantService.addTenants(tenant1, user.getUsername()), propertyMangment1).thenReturn(tenant1);
        mockMvc.perform(post("/api/v1/tenants/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(new ObjectMapper().writeValueAsString(tenant1)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.contract", is(tenant1.getContract())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(tenant1.getNameoftenant())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate", is(tenant1.getStartdate())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate", is(tenant1.getEnddate())));


    }

    @Test
    void updatetenants() {
    }




    @Test
    void deleteTenants() throws Exception {
        mockMvc.perform(delete("/api/v1/tenants/delete/{contract}", tenant1.getContract()))
                .andExpect(status().isOk());
    }
    @Test
    void searchTenants() {
    }
}