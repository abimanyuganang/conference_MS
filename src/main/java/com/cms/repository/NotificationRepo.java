package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.model.Notification;

public interface NotificationRepo extends JpaRepository<Notification, Long> {

}
