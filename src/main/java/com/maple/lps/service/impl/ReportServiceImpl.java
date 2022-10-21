package com.maple.lps.service.impl;

import com.maple.lps.repo.BankRepository;
import com.maple.lps.service.ReportService;
import com.maple.lps.utils.BankReportGenerator;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    BankRepository bankRepository;

    @Autowired
    private BankReportGenerator bankReportGenerator;

    @Override
    public byte[] exportPdf() throws JRException, FileNotFoundException {
        return bankReportGenerator.exportToPdf(bankRepository.findAll());
    }

    @Override
    public byte[] exportXls() throws JRException, FileNotFoundException {
        return bankReportGenerator.exportToXls(bankRepository.findAll());
    }
}
