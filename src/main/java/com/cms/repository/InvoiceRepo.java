package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.model.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, Long> {

}
