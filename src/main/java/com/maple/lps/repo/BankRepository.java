package com.maple.lps.repo;

import com.maple.lps.entity.Bank;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
@EnableJpaRepositories
public interface BankRepository extends CrudRepository<Bank,Integer> {

    List<Bank> findByNameContains(String keyword);
    List<Bank> findBySandi(Integer sandi);
}
