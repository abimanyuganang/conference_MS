package com.cms.service;

import com.cms.model.Venue;
import com.cms.repository.VenueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class VenueService {

    private final VenueRepo venueRepo;

    
    @Autowired
    public VenueService(VenueRepo venueRepo) {
        this.venueRepo = venueRepo;
    }

    // 1. Get all users
    public List<Venue> getALlVenues() {
        return venueRepo.findAll();  
    }

    // 2. Get user by ID
    public Optional<Venue> getVenue(Long id) {
        return venueRepo.findById(id);  
    }

    // 3. Create a new user
    public Venue crVenue(Venue venue) {
        return venueRepo.save(venue);  
    }

    // 4. Update user by ID
    public Venue upReview(Long id, Venue updateVenue) {
        if (venueRepo.existsById(id)) {  
            updateVenue.setVenueId(id);
            return venueRepo.save(updateVenue); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean delVenue(Long id) {
        if (venueRepo.existsById(id)) {  
            venueRepo.deleteById(id);  
            return true;  
        }
        return false;  
    }
}

