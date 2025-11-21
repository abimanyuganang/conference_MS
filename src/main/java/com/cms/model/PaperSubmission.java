package com.cms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "`papersubmission`")
@Entity
public class PaperSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paper_id")
    private Long submissionId;

    private String title;

    @Column(name = "abstract")
    private String abstractText;
    
    private String filePath;
    private String submissionDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "conf_id")
    @JsonIgnore
    private Conference conference;
 
    public void setSubmissionId (Long submissionId){
        this.submissionId=submissionId;
    }
}
