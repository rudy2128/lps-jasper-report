package com.maple.lps.controllers;

import com.maple.lps.model.Bank;
import com.maple.lps.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BankController {
    private List<String>objects = new ArrayList<>();

    @Autowired
    BankService bankService;


    @GetMapping("/bpr")
    public Iterable<Bank>findByAll(){
        return bankService.findAll();

    }
    @PostMapping("/search/{keyword}")
    public List<Bank>searchByName(@PathVariable String keyword) throws IOException {

        return bankService.findByName(keyword);

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
