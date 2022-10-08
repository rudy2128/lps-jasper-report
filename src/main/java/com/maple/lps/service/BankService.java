package com.maple.lps.service;

import com.maple.lps.entity.Bank;
import com.maple.lps.repo.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Bank> findByName(String keyword){
        return bankRepository.findByNameContains(keyword);
    }
    public List<Bank> findBySandi(Integer sandi){
        return bankRepository.findBySandi(sandi);
    }
}
