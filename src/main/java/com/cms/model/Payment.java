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
@Table(name = "`payment`")
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private double amount;
    private String paymentDate;
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setPaymentId (Long paynentId){
        this.paymentId=paynentId;
    }

}
