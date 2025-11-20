package com.cms.service;

import com.cms.model.PaperSubmission;
import com.cms.repository.PaperSubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class PaperSubmissionService {

    private final PaperSubmissionRepo paperSubmissionRepo;

    
    @Autowired
    public PaperSubmissionService(PaperSubmissionRepo paperSubmissionRepo) {
        this.paperSubmissionRepo = paperSubmissionRepo;
    }

    // 1. Get all users
    public List<PaperSubmission> getAllPaperSubmissions() {
        return paperSubmissionRepo.findAll();  
    }

    // 2. Get user by ID
    public Optional<PaperSubmission> getPaper(Long id) {
        return paperSubmissionRepo.findById(id);  
    }

    // 3. Create a new user
    public PaperSubmission crPaperSubmission(PaperSubmission paperSubmission) {
        return paperSubmissionRepo.save(paperSubmission);  
    }

    // 4. Update user by ID
    public PaperSubmission upPaperSubmission(Long id, PaperSubmission updatePaperSubmission) {
        if (paperSubmissionRepo.existsById(id)) {  
            updatePaperSubmission.setSubmissionId(id);
            return paperSubmissionRepo.save(updatePaperSubmission); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean delPaper(Long id) {
        if (paperSubmissionRepo.existsById(id)) {  
            paperSubmissionRepo.deleteById(id);  
            return true;  
        }
        return false;  
    }
}

