package com.cms.service;

import com.cms.model.Notification;
import com.cms.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class NotificationService {

    private final NotificationRepo notificationRepo;

    
    @Autowired
    public NotificationService(NotificationRepo notificationRepo) {
        this.notificationRepo = notificationRepo;
    }

    // 1. Get all users
    public List<Notification> getAllNotifications() {
        return notificationRepo.findAll();  
    }

    // 2. Get user by ID
    public Optional<Notification> getNotification(Long id) {
        return notificationRepo.findById(id);  
    }

    // 3. Create a new user
    public Notification crNotification(Notification notification) {
        return notificationRepo.save(notification);  
    }

    // 4. Update user by ID
    public Notification upAttendance(Long id, Notification updateNotification) {
        if (notificationRepo.existsById(id)) {  
            updateNotification.setNotfId(id);
            return notificationRepo.save(updateNotification); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean delNotification(Long id) {
        if (notificationRepo.existsById(id)) {  
            notificationRepo.deleteById(id);  
            return true;  
        }
        return false;  
    }
}

