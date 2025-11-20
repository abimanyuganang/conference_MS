package com.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    private String paperId;
    private String sessionName;
    private String presenter;
    private String date;
    private String time;
    private String room;
    
    public void setScheduleId (Long scheduleId){
        this.scheduleId=scheduleId;
    }
}