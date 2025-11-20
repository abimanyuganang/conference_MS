package com.cms.service;

import com.cms.model.Conference;
import com.cms.repository.ConferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class ConferenceService {

    private final ConferenceRepo conferenceRepo;

    
    @Autowired
    public ConferenceService(ConferenceRepo conferenceRepo) {
        this.conferenceRepo = conferenceRepo;
    }

    // 1. Get all users
    public List<Conference> getAllConferences() {
        return conferenceRepo.findAll();  
    }
     
    // 2. Get user by ID
    public Optional<Conference> getConference(Long id) {
        return conferenceRepo.findById(id);  
    }

    // 3. Create a new user
    public Conference crConference(Conference conference) {
        return conferenceRepo.save(conference);  
    }

    // 4. Update user by ID
    public Conference upConference(Long id, Conference updateConference) {
        if (conferenceRepo.existsById(id)) {  
            updateConference.setConfId(id);
            return conferenceRepo.save(updateConference); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean delAttendance(Long id) {
        if (conferenceRepo.existsById(id)) {  
            conferenceRepo.deleteById(id);  
            return true;  
        }
        return false;  
    }
}

