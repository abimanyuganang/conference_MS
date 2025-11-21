package com.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "`attendance`")
@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;
    private String checkinTime;
    private String checkoutTime;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setAttendanceId (Long attendanceId){
        this.attendanceId=attendanceId;
    }
}
