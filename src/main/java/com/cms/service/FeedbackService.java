package com.cms.service;

import com.cms.model.Feedback;
import com.cms.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class FeedbackService {

    private final FeedbackRepo feedbackRepo;

    
    @Autowired
    public FeedbackService(FeedbackRepo feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }

    // 1. Get all users
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepo.findAll();  
    }

    // 2. Get user by ID
    public Optional<Feedback> getFeedback(Long id) {
        return feedbackRepo.findById(id);  
    }

    // 3. Create a new user
    public Feedback crFeedback(Feedback feedback) {
        return feedbackRepo.save(feedback);  
    }

    // 4. Update user by ID
    public Feedback upFeedback(Long id, Feedback updateFeedback) {
        if (feedbackRepo.existsById(id)) {  
            updateFeedback.setFeedbackId(id);  
            return feedbackRepo.save(updateFeedback); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean delFeedback(Long id) {
        if (feedbackRepo.existsById(id)) {  
            feedbackRepo.deleteById(id);  
            return true;  
        }
        return false;  
    }
}

