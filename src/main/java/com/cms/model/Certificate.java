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
@Table(name = "`certificate`")
@Entity
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certId;
    private String paperId;
    private String issueDate;
    private String certType;
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setCertId(Long certId) {
        this.certId = certId;
    }

}
