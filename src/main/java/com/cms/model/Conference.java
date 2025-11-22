package com.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Table(name = "`conference`")
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

    public Long getConfId() {
        return confId;
    }

    public void setConfId(Long confId) {
        this.confId = confId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<PaperSubmission> getPaperSubmissions() {
        return paperSubmissions;
    }

    public void setPaperSubmissions(List<PaperSubmission> paperSubmissions) {
        this.paperSubmissions = paperSubmissions;
    }
}
