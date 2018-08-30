package com.eoh.assessment.assessment.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Data
@Getter
@Setter
@Entity(name = "invoice")
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String client;

    @Column
    private long vatRate;

    @Column
    private Date invoiceDate;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<LineItem> lineItems;

    @Transient
    private Long subTotal;
    @Transient
    private BigDecimal vat;
    @Transient
    private BigDecimal total;


    public Invoice() {
        subTotal = 0L;
    }

    public Invoice(Long id, String client, long vatRate, Date invoiceDate, List<LineItem> lineItems) {
        this.id = id;
        this.client = client;
        this.vatRate = vatRate;
        this.invoiceDate = invoiceDate;
        this.lineItems = lineItems;
        subTotal = 0L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public long getVatRate() {
        return vatRate;
    }

    public void setVatRate(long vatRate) {
        this.vatRate = vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public void setSubTotal() {
        for (LineItem lineItem : lineItems) {
            this.subTotal += lineItem.getLineItemTotal().longValue();
        }

    }

    public void setVat() {
        this.vat = BigDecimal.valueOf(subTotal*(getVatRate()/100.0));
    }

    public void setTotal() {
        this.total = BigDecimal.valueOf(subTotal + vat.longValue());
    }
}
