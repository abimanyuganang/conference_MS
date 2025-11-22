package com.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "`acceptance`")
@Entity
public class Acceptance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long acceptId;
    private String decision;
    private String letterSent;
    private String sendDate;

    @ManyToOne
    @JoinColumn(name = "paper_id")
    private PaperSubmission paperSubmission;

    public Long getAcceptId() {
        return acceptId;
    }

    public void setAcceptId(Long acceptId) {
        this.acceptId = acceptId;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getLetterSent() {
        return letterSent;
    }

    public void setLetterSent(String letterSent) {
        this.letterSent = letterSent;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public PaperSubmission getPaperSubmission() {
        return paperSubmission;
    }

    public void setPaperSubmission(PaperSubmission paperSubmission) {
        this.paperSubmission = paperSubmission;
    }
}
