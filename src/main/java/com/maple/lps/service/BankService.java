package com.maple.lps.service;

import com.maple.lps.model.Bank;
import com.maple.lps.repo.BankRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;
import java.io.File;
import java.util.*;

@Service
public class BankService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BankService.class);

    @Autowired
    BankRepository bankRepository;
   @Value("${bpr-service.get-data}")
    private String baseUrl;
    private final RestTemplate restTemplate;

    @Autowired
    public BankService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Iterable<Bank> findAll(){
        return bankRepository.findAll();
    }
    public void saveBank(Bank bank){
        bankRepository.save(bank);
    }
    public void deleteById(Integer id){
        bankRepository.deleteById(id);
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

    public String generateReport() {
        try {

            List<Bank> banks = bankRepository.findAll();

            File file = ResourceUtils.getFile("classpath:bpr_list.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());


            String reportPath = "/Users/qaa/Documents/reports";


            // Get your data source
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(banks);

            // Add parameters
            Map<String, Object> parameters = new HashMap<>();

            parameters.put("createdBy", "alldata.org");

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                    jrBeanCollectionDataSource);

            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "/bprReport.pdf");

            System.out.println("Done");

            return "Report successfully generated @path= " + reportPath;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error--> check the console log";
        }
    }

    public void fetchDataFromApi() {
        try {
            ResponseEntity<Bank[]> response =
                    restTemplate.getForEntity(baseUrl, Bank[].class);
            Bank[] banks = response.getBody();

            File file = ResourceUtils.getFile("classpath:bpr_list.jrxml");

            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            String reportPath = "/Users/qaa/Documents/reports";
            // Process the API response as needed
            System.out.println(banks);
            assert banks != null;
            JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(Arrays.asList(banks));
            // Add parameters
            Map<String, Object> parameters = new HashMap<>();

            parameters.put("createdBy", "alldata.org");

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                    jrBeanCollectionDataSource);

            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "/bprListReport.pdf");

            System.out.println("Done");

//            return "Report successfully generated @path= " + reportPath;


        }catch (Exception e) {
            e.printStackTrace();
        }
//        return "Error--> check the console log";

    }


}

