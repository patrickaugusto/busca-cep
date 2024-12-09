package com.example.busca_cep.services;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.busca_cep.models.Address;

@Service
public class AddressService {

    @Autowired
    private RestTemplate restTemplate;

    private final String url = "https://viacep.com.br/ws/{cep}/json/";

    public Address fetchAddress(Integer cep){
        ResponseEntity<Address> response = restTemplate.getForEntity(url, Address.class, cep);
        Address address = response.getBody();
        if (address == null){
            throw new RuntimeErrorException(null);
        }
        return address;
    }
}
