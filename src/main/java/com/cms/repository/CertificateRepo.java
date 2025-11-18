package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.model.Certificate;

public interface CertificateRepo extends JpaRepository<Certificate, Long> {

}
