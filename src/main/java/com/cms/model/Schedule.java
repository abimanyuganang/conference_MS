package com.cms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "`schedule`")
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    private String paperId;
    private String sessionName;

    @Column(name = "presenter_id")
    private String presenter;

    private String time;
    private String room;
    
    public void setScheduleId (Long scheduleId){
        this.scheduleId=scheduleId;
    }
}
