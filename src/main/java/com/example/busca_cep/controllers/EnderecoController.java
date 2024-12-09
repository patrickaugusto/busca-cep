package com.example.busca_cep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.busca_cep.models.Endereco;
import com.example.busca_cep.services.EnderecoService;

@RestController
@RequestMapping("consultar-cep/")
public class EnderecoController {

    @Autowired
    private EnderecoService addressService;
    
    @GetMapping("{cep}")
    public Endereco getAddress(@PathVariable Integer cep){
        return addressService.fetchEndereco(cep);
    }
}
