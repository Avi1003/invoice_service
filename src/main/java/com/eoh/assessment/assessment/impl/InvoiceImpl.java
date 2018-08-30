package com.eoh.assessment.assessment.impl;

import com.eoh.assessment.assessment.domain.Invoice;
import com.eoh.assessment.assessment.domain.LineItem;
import com.eoh.assessment.assessment.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class InvoiceImpl {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public String saveInvoice(String client, Long vatRate, Date invoiceDate, List<LineItem> lineItems) {
        try {
            Invoice invoice = new Invoice();
            invoice.setClient(client);
            invoice.setVatRate(vatRate);
            invoice.setInvoiceDate(invoiceDate);
            invoice.setLineItems(lineItems);
            invoiceRepository.save(invoice);
            return "Invoiced Saved Successfully";
        } catch (Exception ex){
            return "Error saving invoice : "+ ex.getMessage();
        }
    }

}
