package com.maple.lps.controllers;

import com.maple.lps.model.Bank;
import com.maple.lps.service.BankService;
import com.maple.lps.service.ReportService;
import lombok.var;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    BankService bankService;

    @Autowired
    ReportService reportService;

    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpSession session;

//    @GetMapping("/bpr")
//    public void getBankReport()throws Exception{
//        response.setContentType("application/pdf");
//        response.setHeader("Content-Disposition","attachment:filename=\"bpr-report.pdf\"");
////        String searchKey = session.getAttribute("searchKey").toString();
//        JasperPrint jasperPrint = reportService.generateJasperPrint();
//        JasperExportManager.exportReportToPdfStream(jasperPrint,response.getOutputStream());
//
//    }
@GetMapping(value = "/list-bpr")
public void getBpr() throws UnknownHostException {
    bankService.fetchDataFromApi();
}


//@GetMapping("/export-xls")
//public ResponseEntity<byte[]> exportXls() throws JRException, FileNotFoundException {
//    HttpHeaders headers = new HttpHeaders();
//    headers.set("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8");
//    var contentDisposition = ContentDisposition.builder("attachment")
//            .filename("petsReport" + ".xls").build();
//    headers.setContentDisposition(contentDisposition);
//    return ResponseEntity.ok()
//            .headers(headers)
//            .body(reportService.exportXls());
//}
//    @GetMapping("/export-pdf")
//    public ResponseEntity<byte[]> exportPdf() throws JRException, FileNotFoundException {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_PDF);
//        headers.setContentDispositionFormData("bprReport", "bprReport.pdf");
//        return ResponseEntity.ok().headers(headers).body(reportService.exportPdf());
//    }
}
