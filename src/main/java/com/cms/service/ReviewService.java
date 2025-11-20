package com.cms.service;

import com.cms.model.Review;
import com.cms.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class ReviewService {

    private final ReviewRepo reviewRepo;

    
    @Autowired
    public ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    // 1. Get all users
    public List<Review> getAllAcceptances() {
        return reviewRepo.findAll();  
    }

    // 2. Get user by ID
    public Optional<Review> getReview(Long id) {
        return reviewRepo.findById(id);  
    }

    // 3. Create a new user
    public Review crReview(Review review) {
        return reviewRepo.save(review);  
    }

    // 4. Update user by ID
    public Review upReview(Long id, Review updateReview) {
        if (reviewRepo.existsById(id)) {  
            updateReview.setReviewId(id);
            return reviewRepo.save(updateReview); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean delAcceptance(Long id) {
        if (reviewRepo.existsById(id)) {  
            reviewRepo.deleteById(id);  
            return true;  
        }
        return false;  
    }
}
