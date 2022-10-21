package com.maple.lps.controllers;

import com.maple.lps.model.Bank;
import com.maple.lps.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public ResponseEntity<Iterable<Bank>> findAll(HttpServletResponse response){
        HttpHeaders headers = new HttpHeaders();
        response.setHeader("Bpr","LisBpr");
        return ResponseEntity.ok()
                .headers(headers)
                .body(bankService.findAll());

    }

    @DeleteMapping("/delete-by-sandi/{$id}")
    public void deleteById(@RequestParam Integer id){
        bankService.deleteById(id);

    }
    @PostMapping("/save")
    public void saveBank(@RequestBody Bank bank){
        bankService.saveBank(bank);
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

    @GetMapping("/report")
    public String generateReport() {

        return bankService.generateReport();
    }



    @PostMapping("/contains")
    public List<Bank>searchByContains(@PathVariable String key)throws NullPointerException {
        if (key == ".*Prov.*"){
            String provinsi = key;
            return bankService.findByProv(provinsi);
        } else if (key == ".*Kota.*") {
            String city = key;
            return bankService.findByCity(city);
        } else if (key == "^[\\p{L} \\.'\\-]+$") {
            String name = key;
            return bankService.findByName(name);
        } else if (key == "\\d{6}$") {
            int sandi = Integer.parseInt(key);
            return bankService.findBySandi(sandi);

        }
        return searchByContains(key);
    }


    @GetMapping("/bpr/{id}")
    public Optional<Bank> getBankById(@PathVariable Integer id) throws UnknownHostException{
        return bankService.findById(id);

    }

}
