package com.maple.lps.repo;

import com.maple.lps.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BankRepository extends JpaRepository<Bank,Integer> {

    List<Bank> findByNameContains(String name);
    List<Bank> findBySandi(Integer sandi);
    List<Bank> findByProvinsiContains(String provinsi);
    List<Bank> findByCityContains(String city);

    List<Bank>findByNameOrProvinsiOrCityContains(String name,String provinsi,String city);
}
