package com.cms.service;

import com.cms.model.Invoice;
import com.cms.repository.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class InvoiceService {

    private final InvoiceRepo invoiceRepo;

    
    @Autowired
    public InvoiceService(InvoiceRepo invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }

    // 1. Get all users
    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();  
    }

    // 2. Get user by ID
    public Optional<Invoice> getInvoice(Long id) {
        return invoiceRepo.findById(id);  
    }

    // 3. Create a new user
    public Invoice crInvoice(Invoice invoice) {
        return invoiceRepo.save(invoice);  
    }

    // 4. Update user by ID
    public Invoice upInvoice(Long id, Invoice updateInvoice) {
        if (invoiceRepo.existsById(id)) {  
            updateInvoice.setInvoiceId(id);  
            return invoiceRepo.save(updateInvoice); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean delInvoice(Long id) {
        if (invoiceRepo.existsById(id)) {  
            invoiceRepo.deleteById(id);  
            return true;  
        }
        return false;  
    }
}
