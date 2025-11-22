package com.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "`review`")
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

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public PaperSubmission getPaperSubmission() {
        return paperSubmission;
    }

    public void setPaperSubmission(PaperSubmission paperSubmission) {
        this.paperSubmission = paperSubmission;
    }

    public Author getReviewer() {
        return reviewer;
    }

    public void setReviewer(Author reviewer) {
        this.reviewer = reviewer;
    }
}
