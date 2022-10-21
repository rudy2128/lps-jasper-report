package com.maple.lps.controllers;

import com.maple.lps.model.Bank;
import com.maple.lps.service.BankService;
import io.swagger.v3.oas.annotations.headers.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping
public class BankController {
    private List<String>objects = new ArrayList<>();

    @Autowired
    BankService bankService;


    @GetMapping("/bpr")
    public Iterable<Bank>findAll(){
        return bankService.findAll();

    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/names/{name}")
    public List<Bank>searchByName(@PathVariable String name) throws UnknownHostException{
        return bankService.findByName(name);

    }

    @GetMapping("/search/{sandi}")
    public List<Bank>searchSandi(@PathVariable Integer sandi) throws UnknownHostException {
        return bankService.findBySandi(sandi);
    }
    @PostMapping("/cari/{provinsi}")
    public List<Bank>searchByProv(@PathVariable String provinsi)throws UnknownHostException{
        return bankService.findByProv(provinsi);
    }

    @PostMapping("/look/{city}")
    public List<Bank>searchByCity(@PathVariable String city)throws UnknownHostException{
        return bankService.findByCity(city);
    }

//    @PostMapping("/contains")
//    public List<Bank>searchByContains(@PathVariable String key)throws NullPointerException {
//        if (key == ".*Prov.*"){
//            String provinsi = key;
//            return bankService.findByProv(provinsi);
//        } else if (key == ".*Kota.*") {
//            String city = key;
//            return bankService.findByCity(city);
//        } else if (key == "^[\\p{L} \\.'\\-]+$") {
//            String name = key;
//            return bankService.findByName(name);
//        } else if (key == "\\d{6}$") {
//            int sandi = Integer.parseInt(key);
//            return bankService.findBySandi(sandi);
//
//        }
//        return searchByContains(key);
//    }


    @GetMapping("/bpr/{id}")
    public Optional<Bank> getBankById(@PathVariable Integer id) throws UnknownHostException{
        return bankService.findById(id);

    }

}
