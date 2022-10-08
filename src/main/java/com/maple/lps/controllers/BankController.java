package com.maple.lps.controllers;

import com.maple.lps.entity.Bank;
import com.maple.lps.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class BankController {
    @Autowired
    BankService bankService;


    @GetMapping("/bpr")
    public Iterable<Bank>findByAll(){
        return bankService.findAll();

    }
    @PostMapping("/search/{keyword}")
    public List<Bank>search(@PathVariable String keyword) throws UnknownHostException {
        return bankService.findByName(keyword);

    }

    @GetMapping("/search/{sandi}")
    public List<Bank>searchSandi(@PathVariable Integer sandi) throws UnknownHostException {
        return bankService.findBySandi(sandi);

    }
    @GetMapping("/bpr/{id}")
    public Optional<Bank> getBankById(@PathVariable Integer id) throws UnknownHostException{
        return bankService.findById(id);

    }

}
