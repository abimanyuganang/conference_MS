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
@Table(name = "`notification`")
@Entity
public class Notification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notif_id")
    private Long notfId;
    
    private String title;
    private String message;
    private String dataSent;
    private String status;
    
    public void setNotfId (Long notfId){
        this.notfId=notfId;
    }
}
