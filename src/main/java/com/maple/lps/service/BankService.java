package com.maple.lps.service;

import com.maple.lps.model.Bank;
import com.maple.lps.repo.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;


    public Iterable<Bank> findAll(){
        return bankRepository.findAll();
    }

    public Optional<Bank> findById(Integer id){
        return bankRepository.findById(id);
    }
    public List<Bank> findByName(String name){
        return bankRepository.findByNameContains(name);
    }
    public List<Bank> findBySandi(Integer sandi){
        return bankRepository.findBySandi(sandi);
    }
    public List<Bank>findByProv(String provinsi){
        return bankRepository.findByProvinsiContains(provinsi);
    }
    public List<Bank>findByCity(String city){
        return bankRepository.findByCityContains(city);
    }
    public List<Bank>findByContains(String name, String provinsi,String city){
        return bankRepository.findByNameOrProvinsiOrCityContains(name, provinsi, city);
    }
}
