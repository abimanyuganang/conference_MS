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

    public void setAcceptId (Long acceptId){
        this.acceptId=acceptId;
    }
}
