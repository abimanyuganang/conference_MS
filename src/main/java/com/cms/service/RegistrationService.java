package com.cms.service;

import com.cms.model.Registration;
import com.cms.repository.RegistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class RegistrationService {

    private final RegistRepo registRepo;

    
    @Autowired
    public RegistrationService(RegistRepo registRepo) {
        this.registRepo = registRepo;
    }

    // 1. Get all users
    public List<Registration> getAllRegistrations() {
        return registRepo.findAll();  
    }

    // 2. Get user by ID
    public Optional<Registration> getRegistration(Long id) {
        return registRepo.findById(id);  
    }

    // 3. Create a new user
    public Registration crRegistration(Registration registration) {
        return registRepo.save(registration);  
    }

    // 4. Update user by ID
    public Registration upRegistration(Long id, Registration upRegistration) {
        if (registRepo.existsById(id)) {  
            upRegistration.setRegId(id); 
            return registRepo.save(upRegistration); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean delAcceptance(Long id) {
        if (registRepo.existsById(id)) {  
            registRepo.deleteById(id);  
            return true;  
        }
        return false;  
    }
}
