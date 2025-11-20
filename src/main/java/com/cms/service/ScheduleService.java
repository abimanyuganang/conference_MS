package com.cms.service;

import com.cms.model.Schedule;
import com.cms.repository.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class ScheduleService {

    private final ScheduleRepo scheduleRepo;

    
    @Autowired
    public ScheduleService(ScheduleRepo scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }

    // 1. Get all users
    public List<Schedule> getAllSchedules() {
        return scheduleRepo.findAll();  
    }

    // 2. Get user by ID
    public Optional<Schedule> getSchedule(Long id) {
        return scheduleRepo.findById(id);  
    }

    // 3. Create a new user
    public Schedule crSchedule(Schedule schedule) {
        return scheduleRepo.save(schedule);  
    }

    // 4. Update user by ID
    public Schedule upSchedule(Long id, Schedule updateSchedule) {
        if (scheduleRepo.existsById(id)) {  
            updateSchedule.setScheduleId(id);
            return scheduleRepo.save(updateSchedule); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean delSchedule(Long id) {
        if (scheduleRepo.existsById(id)) {  
            scheduleRepo.deleteById(id);  
            return true;  
        }
        return false;  
    }
}

