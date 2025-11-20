package com.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long confId;
    private String name;
    private String startDate;
    private String endDate;
    private String location;

    @OneToMany(mappedBy = "conference")
    private List<PaperSubmission> paperSubmissions;

    public void setConfId (Long confId){
        this.confId=confId;
    }
}