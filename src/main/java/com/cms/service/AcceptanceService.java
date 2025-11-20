package com.cms.service;

import com.cms.model.Acceptance;
import com.cms.repository.AcceptanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class AcceptanceService {

    private final AcceptanceRepo acceptanceRepo;

    
    @Autowired
    public AcceptanceService(AcceptanceRepo acceptanceRepo) {
        this.acceptanceRepo = acceptanceRepo;
    }

    // 1. Get all users
    public List<Acceptance> getAllAcceptances() {
        return acceptanceRepo.findAll();  
    }

    // 2. Get user by ID
    public Optional<Acceptance> getAcceptance(Long id) {
        return acceptanceRepo.findById(id);  
    }

    // 3. Create a new user
    public Acceptance crAcceptance(Acceptance acceptance) {
        return acceptanceRepo.save(acceptance);  
    }

    // 4. Update user by ID
    public Acceptance updAcceptance(Long id, Acceptance uAcceptance) {
        if (acceptanceRepo.existsById(id)) {  
            uAcceptance.setAcceptId(id); 
            return acceptanceRepo.save(uAcceptance); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean delAcceptance(Long id) {
        if (acceptanceRepo.existsById(id)) {  
            acceptanceRepo.deleteById(id);  
            return true;  
        }
        return false;  
    }
}

