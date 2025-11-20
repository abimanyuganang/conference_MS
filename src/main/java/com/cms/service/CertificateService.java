package com.cms.service;

import com.cms.model.Certificate;
import com.cms.repository.CertificateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class CertificateService {

    private final CertificateRepo certificateRepo;

    
    @Autowired
    public CertificateService(CertificateRepo certificateRepo) {
        this.certificateRepo = certificateRepo;
    }

    // 1. Get all users
    public List<Certificate> getAllCertificates() {
        return certificateRepo.findAll();  
    }

    // 2. Get user by ID
    public Optional<Certificate> getCertificate(Long id) {
        return certificateRepo.findById(id);  
    }

    // 3. Create a new user
    public Certificate crCertificate(Certificate certificate) {
        return certificateRepo.save(certificate);  
    }

    // 4. Update user by ID
    public Certificate upCertificate(Long id, Certificate updateCertificate) {
        if (certificateRepo.existsById(id)) {  
            updateCertificate.setCertId(id);  
            return certificateRepo.save(updateCertificate); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean delCertificate(Long id) {
        if (certificateRepo.existsById(id)) {  
            certificateRepo.deleteById(id);  
            return true;  
        }
        return false;  
    }
}

