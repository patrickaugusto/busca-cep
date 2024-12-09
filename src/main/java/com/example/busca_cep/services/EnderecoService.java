package com.example.busca_cep.services;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.busca_cep.models.Endereco;

@Service
public class EnderecoService {

    @Autowired
    private RestTemplate restTemplate;

    private final String url = "https://viacep.com.br/ws/{cep}/json/";

    public Endereco fetchEndereco(Integer cep){
        ResponseEntity<Endereco> response = restTemplate.getForEntity(url, Endereco.class, cep);
        Endereco address = response.getBody();
        if (address == null){
            throw new RuntimeErrorException(null);
        }
        return address;
    }
}
