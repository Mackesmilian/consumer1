package com.wolf.consumer1.service;

import com.wolf.consumer1.entity.Customer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerService {

    private final RestTemplate restTemplate;

    public CustomerService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Customer> getAlLCustomers() {
        ResponseEntity<List<Customer>> customerResponseEntity = restTemplate.exchange(
                "http://localhost:8080/customers", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Customer>>(){});
        return customerResponseEntity.getBody();
    }
}
