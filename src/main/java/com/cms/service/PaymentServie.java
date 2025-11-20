package com.cms.service;

import com.cms.model.Payment;
import com.cms.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class PaymentServie {

    private final PaymentRepo paymentRepo;

    
    @Autowired
    public PaymentServie(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    // 1. Get all users
    public List<Payment> getALlPayments() {
        return paymentRepo.findAll();  
    }

    // 2. Get user by ID
    public Optional<Payment> getPayment(Long id) {
        return paymentRepo.findById(id);  
    }

    // 3. Create a new user
    public Payment crPayment(Payment payment) {
        return paymentRepo.save(payment);  
    }

    // 4. Update user by ID
    public Payment upPayment(Long id, Payment updatePayment) {
        if (paymentRepo.existsById(id)) {  
            updatePayment.setPaymentId(id);
            return paymentRepo.save(updatePayment); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean delPayment(Long id) {
        if (paymentRepo.existsById(id)) {  
            paymentRepo.deleteById(id);  
            return true;  
        }
        return false;  
    }
}

