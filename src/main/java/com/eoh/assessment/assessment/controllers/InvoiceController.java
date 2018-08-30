package com.eoh.assessment.assessment.controllers;

import com.eoh.assessment.assessment.domain.Invoice;
import com.eoh.assessment.assessment.repositories.InvoiceRepository;
import com.eoh.assessment.assessment.repositories.LineItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private LineItemRepository lineItemRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/invoices")
    @ResponseBody
    public Invoice saveInvoices(@RequestBody Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/invoices")
    @ResponseBody
    public List<Invoice> getInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        for(Invoice invoice : invoices){
            invoice.setSubTotal();
            invoice.setVat();
            invoice.setTotal();
        }
        return invoices;
    }

    @RequestMapping(method = RequestMethod.GET, path = "invoices/{invoiceId}")
    @ResponseBody
    public Optional<Invoice> getInvoice(@PathVariable("invoiceId") Long invoiceId) {
        Optional<Invoice> invoice = invoiceRepository.findById(invoiceId);
        invoice.get().setSubTotal();
        invoice.get().setVat();
        invoice.get().setTotal();
        return invoice;
    }

}
