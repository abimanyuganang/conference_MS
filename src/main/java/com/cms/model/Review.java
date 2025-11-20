package com.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private int score;
    private String comments;
    private String reviewDate;

    @ManyToOne
    @JoinColumn(name = "paper_id")
    private PaperSubmission paperSubmission;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    private Author reviewer;

    public void setReviewId (Long reviewId){
        this.reviewId=reviewId;
    }

}
