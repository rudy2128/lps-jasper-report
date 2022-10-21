package com.maple.lps.service;

import com.maple.lps.model.Bank;
import com.maple.lps.model.ReqBank;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;




public interface ReportService {

    byte[] exportPdf() throws JRException, FileNotFoundException;
    byte[] exportXls() throws JRException, FileNotFoundException;

//    @Value("${bpr-service.get-data}")
//    private String baseUrl;
//
//
//
//    private ResponseEntity<Bank> getConnection(ReqBank requestBody){
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Accept","application/json");
//        HttpEntity<ReqBank> request = new HttpEntity<>(requestBody, headers);
//        Bank responseBody = null;
//        try {
//            responseBody = restTemplate.postForObject(baseUrl,request,Bank.class);
//            return ResponseEntity.ok(responseBody);
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return  null;
//        }
//    }


//    public JasperPrint generateJasperPrint()throws Exception{
//        InputStream fileReport = new ClassPathResource("/report/bpr_list.jasper").getInputStream();
//        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(fileReport);
////        Map<String,Object> params = new HashMap<>();
////        params.put("ename","%"+paramName+"%");
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, (Connection) getConnection(ReqBank.builder().build()));
//
//        return jasperPrint;
//    }
}

