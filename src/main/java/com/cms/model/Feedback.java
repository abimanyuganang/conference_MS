package com.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;
    private int rating;
    private String comments;
    private String date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    public void setFeedbackId (Long feedbackId){
        this.feedbackId=feedbackId;
    }
}