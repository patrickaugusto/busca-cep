package com.example.busca_cep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.busca_cep.models.Address;
import com.example.busca_cep.services.AddressService;

@RestController
@RequestMapping("consultar-cep/")
public class AddressController {

    @Autowired
    private AddressService addressService;
    
    @GetMapping("{cep}")
    public Address getAddress(@PathVariable Integer cep){
        return addressService.fetchAddress(cep);
    }
}
