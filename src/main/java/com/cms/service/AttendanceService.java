package com.cms.service;

import com.cms.model.Attendance;
import com.cms.repository.AttendanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service  
public class AttendanceService {

    private final AttendanceRepo attendanceRepo;

    
    @Autowired
    public AttendanceService(AttendanceRepo attendanceRepo) {
        this.attendanceRepo = attendanceRepo;
    }

    // 1. Get all users
    public List<Attendance> getAllAttendances() {
        return attendanceRepo.findAll();  
    }

    // 2. Get user by ID
    public Optional<Attendance> getAttendance(Long id) {
        return attendanceRepo.findById(id);  
    }

    // 3. Create a new user
    public Attendance crAttendance(Attendance attendance) {
        return attendanceRepo.save(attendance);  
    }

    // 4. Update user by ID
    public Attendance upAttendance(Long id, Attendance updateAttendance) {
        if (attendanceRepo.existsById(id)) {  
            updateAttendance.setAttendanceId(id);  
            return attendanceRepo.save(updateAttendance); 
        }
        return null;  
    }

    // 5. Delete user by ID
    public boolean delAttendance(Long id) {
        if (attendanceRepo.existsById(id)) {  
            attendanceRepo.deleteById(id);  
            return true;  
        }
        return false;  
    }
}

