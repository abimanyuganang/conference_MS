package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
