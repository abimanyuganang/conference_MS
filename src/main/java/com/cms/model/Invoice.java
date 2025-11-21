package com.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "`invoice`")
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;
    private String issueDate;
    private String dueDate;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
     
    public void setInvoiceId (Long invoiceId){
        this.invoiceId=invoiceId;
    }
}
